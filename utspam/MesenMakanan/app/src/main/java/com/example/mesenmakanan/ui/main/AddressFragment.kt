package com.example.mesenmakanan.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mesenmakanan.R

class AddressFragment : Fragment(R.layout.fragment_address) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etFullName = view.findViewById<EditText>(R.id.et_full_name)
        val etAddress = view.findViewById<EditText>(R.id.et_address)
        val etFullAddressNotes = view.findViewById<EditText>(R.id.et_address_detail)
        val buttonOrder = view.findViewById<Button>(R.id.btn_order_and_send)

        buttonOrder.setOnClickListener {
            val fullName = etFullName.text.toString()
            val address = etAddress.text.toString()
            val notes = etFullAddressNotes.text.toString()

            var isValid = true

            etFullName.error = null
            etAddress.error = null
            etFullAddressNotes.error = null

            if (fullName.isBlank()) {
                etFullName.error = "Nama lengkap wajib diisi"
                isValid = false
            }

            if (address.isBlank()) {
                etAddress.error = "Alamat wajib diisi"
                isValid = false
            }

            if (notes.isBlank()) {
                etFullAddressNotes.error = "Masukan alamat lengkap wajib diisi"
                isValid = false
            }

            if (isValid) {
                findNavController().navigate(R.id.action_addressFragment_to_thankYouFragment)
            } else {
                Toast.makeText(requireContext(), "Harap isi semua form", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

