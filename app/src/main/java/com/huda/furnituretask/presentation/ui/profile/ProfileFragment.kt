package com.huda.furnituretask.presentation.ui.profile

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.FragmentProfileBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    var sharedPref: SharedPreferences? = null
        @Inject set

    @Inject
    lateinit var auth: FirebaseAuth

    @Inject
    lateinit var mGoogleSignInClient: GoogleSignInClient

    var account: GoogleSignInAccount? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        account = GoogleSignIn.getLastSignedInAccount(requireContext())

        binding.signOut.setOnClickListener {
            if (account != null) {
                mGoogleSignInClient.signOut()
                with(sharedPref?.edit()) {
                    this?.putString("social_token", null)
                    this?.apply()
                }
                findNavController().popBackStack()
            } else if (auth.currentUser != null) {
                auth.signOut()
                LoginManager.getInstance().logOut()
                findNavController().popBackStack()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.VISIBLE)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}