package com.huda.furnituretask.presentation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.FragmentLoginBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.createNewAccount)
        }
        binding.facebookLogin.setOnClickListener{
            findNavController().navigate(R.id.viewHome)

        }
    }

    override fun onStart() {
        super.onStart()
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.GONE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}