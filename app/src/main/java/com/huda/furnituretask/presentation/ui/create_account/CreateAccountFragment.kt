package com.huda.furnituretask.presentation.ui.create_account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.FragmentCreateAccountBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAccountFragment : Fragment() {

    private var _binding: FragmentCreateAccountBinding? = null

    private val binding get() = _binding!!

    val viewModel by viewModels<CreateAccountViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.registerMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
        viewModel.customerLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                findNavController().navigate(R.id.viewHome)
            }
        }
        binding.buttonCreateAccount.setOnClickListener {
            if (checkDataNotEmpty()) {

                viewModel.register(
                    name = binding.name.text.toString(),
                    email = binding.email.text.toString(),
                    phone = binding.phoneNum.text.toString(),
                    address = binding.address.text.toString(),
                    password = binding.password.text.toString(),
                    passwordConfirmation = binding.confirmPassword.text.toString()
                )
            }
        }
    }

    private fun checkDataNotEmpty(): Boolean {
        var isNotEmpty = true
        if (binding.name.text.isNullOrEmpty()) {
            binding.name.error = "يجب إدخال الأسم"
            isNotEmpty = false
        }
        if (binding.email.text.isNullOrEmpty()) {
            binding.email.error = "يجب إدخال البريد الإلكتروني"
            isNotEmpty = false
        }
        if (binding.phoneNum.text.isNullOrEmpty()) {
            binding.phoneNum.error = "يجب إدخال رقم الهاتف"
            isNotEmpty = false
        }
        if (binding.address.text.isNullOrEmpty()) {
            binding.address.error = "يجب إدخال العنوان"
            isNotEmpty = false
        }
        if (binding.password.text.isNullOrEmpty()) {
            binding.password.error = "يجب إدخال الرقم السري"
            isNotEmpty = false
        }
        if (binding.confirmPassword.text.isNullOrEmpty()) {
            binding.confirmPassword.error = "يجب إدخال تأكيد الرقم السري"
            isNotEmpty = false
        }
        return isNotEmpty
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