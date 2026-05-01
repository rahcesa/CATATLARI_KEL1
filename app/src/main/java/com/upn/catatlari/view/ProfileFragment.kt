package com.upn.catatlari.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.upn.catatlari.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = (activity as MainActivity).user

        binding.txtProfileName.text =
            user?.email ?: "Pengguna CatatLari"

        // 🔥 BUTTON EDIT PROFILE
        binding.btnEditProfile.setOnClickListener {

            val editText = EditText(requireContext())

            editText.setText(binding.txtProfileName.text.toString())

            AlertDialog.Builder(requireContext())
                .setTitle("Edit Profil")
                .setMessage("Ubah nama profil")
                .setView(editText)

                .setPositiveButton("Simpan") { _, _ ->

                    val newName = editText.text.toString()

                    if (newName.isNotBlank()) {

                        binding.txtProfileName.text = newName

                        Toast.makeText(
                            requireContext(),
                            "Profil berhasil diupdate",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                .setNegativeButton("Batal", null)
                .show()
        }

        // 🔥 BUTTON LOGOUT
        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setTitle("Keluar")
                .setMessage("Yakin ingin keluar akun?")

                .setPositiveButton("Ya") { _, _ ->

                    Toast.makeText(
                        requireContext(),
                        "Berhasil logout",
                        Toast.LENGTH_SHORT
                    ).show()

                    // kembali ke login
                    val intent =
                        Intent(requireContext(), AuthActivity::class.java)

                    startActivity(intent)

                    activity?.finish()
                }

                .setNegativeButton("Batal", null)
                .show()
        }
    }
}