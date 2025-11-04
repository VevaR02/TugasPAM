package com.example.mesenmakanan.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mesenmakanan.MainActivity
import com.example.mesenmakanan.R

class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etFullName = view.findViewById<EditText>(R.id.et_full_name)
        val etUsername = view.findViewById<EditText>(R.id.et_username)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val buttonRegister = view.findViewById<Button>(R.id.btn_register)

        buttonRegister.setOnClickListener {
            val fullName = etFullName.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            var isValid = true

            etFullName.error = null
            etUsername.error = null
            etPassword.error = null

            if (fullName.isBlank()) {
                etFullName.error = "Nama lengkap wajib diisi"
                isValid = false
            }

            if (username.isBlank()) {
                etUsername.error = "Username wajib diisi"
                isValid = false
            }

            if (password.isBlank()) {
                etPassword.error = "Password wajib diisi"
                isValid = false
            }

            if (isValid) {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                Toast.makeText(requireContext(), "Harap isi semua form", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

