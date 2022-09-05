package com.huda.furnituretask.presentation.ui.login

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.FragmentLoginBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Inject


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var callbackManager: CallbackManager
    var sharedPref: SharedPreferences? = null
        @Inject set

    @Inject
    lateinit var auth: FirebaseAuth

    @Inject
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private var _binding: FragmentLoginBinding? = null
    val viewModel: LoginViewModel by viewModels()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
      /*  try {
            val info: PackageInfo = requireActivity().packageManager.getPackageInfo(
                "com.huda.furnituretask",
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("YourKeyHash :", Base64.encodeToString(md.digest(), Base64.DEFAULT))
                println(
                    "YourKeyHash: "+
                    Base64.encodeToString(md.digest(), Base64.DEFAULT)
                )
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }*/
        callbackManager = CallbackManager.Factory.create()
        binding.facebookLogin.setFragment(this)

        binding.facebookLogin.setPermissions("email", "public_profile")
        binding.facebookLogin.setLoginText(getString(R.string.facebook_login))
        binding.facebookLogin.setLogoutText("تسجيل الخروج")
        binding.facebookLogin.registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                Log.d("TAG", "facebook:onSuccess:$result")
                handleFacebookAccessToken(result.accessToken)
            }

            override fun onCancel() {
                Log.d("TAG", "facebook:onCancel")
            }

            override fun onError(error: FacebookException) {
                Log.d("TAG", "facebook:onError", error)
            }
        })

        binding.buttonLogin.setOnClickListener {
            viewModel.login(
                binding.emailOrPhoneNum.text.toString(),
                binding.password.text.toString()
            )
        }
        viewModel.isUsernameOrPasswordEmpty.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
        }
        viewModel.loginMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
        viewModel.customer.observe(viewLifecycleOwner) {
            if (it != null) {
                findNavController().navigate(R.id.viewHome)
            }
        }
        binding.googleLogin.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
//        binding.facebookLogin.setOnClickListener {
//            findNavController().navigate(R.id.viewHome)
//        }
        binding.createNewAccount.setOnClickListener {
            findNavController().navigate(R.id.createNewAccount)
        }


    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        checkGoogleLogin(account)
        val currentUser = auth.currentUser
        checkFacebookLogin(currentUser)
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.GONE)
    }

    private fun checkFacebookLogin(currentUser: FirebaseUser?) {
        if (currentUser!=null){
            viewModel.checkSocialLogin(
                providerType = Constants.FACEBOOK,
                currentUser.uid,
                currentUser.displayName!!,
                currentUser.email!!
            )
        }
    }
    private fun checkGoogleLogin(account: GoogleSignInAccount?) {

        if (account != null) {
            val socialToken = sharedPref?.getString("social_token", null)
            viewModel.checkSocialLogin(
                providerType = Constants.GOOGLE,
                account.serverAuthCode ?: socialToken,
                account.displayName!!,
                account.email!!
            )
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d("TAG", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG12", "signInWithCredential:success")
                    val user = auth.currentUser
                    checkFacebookLogin(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG12", "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        requireContext(), "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    checkFacebookLogin(null)
                }
            }
    }


    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            with(sharedPref?.edit()) {
                this?.putString("social_token", account.serverAuthCode)
                this?.apply()
            }
            checkGoogleLogin(account)
        } catch (e: ApiException) {
            Toast.makeText(
                requireContext(),
                "signInResult:failed code= ${e.statusCode}, message=${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {
        const val RC_SIGN_IN = 1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}