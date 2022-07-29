package com.huda.furnituretask.presentation.ui.create_account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.FragmentCreateAccountBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CreateAccountFragment : Fragment() {

    private var _binding: FragmentCreateAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.loginToApp)
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