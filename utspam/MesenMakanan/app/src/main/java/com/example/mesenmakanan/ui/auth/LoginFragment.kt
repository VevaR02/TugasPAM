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

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etUsername = view.findViewById<EditText>(R.id.et_username)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val buttonLogin = view.findViewById<Button>(R.id.btn_login)

        buttonLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            var isValid = true

            etUsername.error = null
            etPassword.error = null

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

