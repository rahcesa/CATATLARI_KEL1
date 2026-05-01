package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.catatlari.databinding.FragmentHomeBinding
import com.upn.catatlari.viewmodel.RunViewModel
import android.widget.Toast

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val runViewModel: RunViewModel by activityViewModels()
    private var isEditMode = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val user = (activity as MainActivity).user
        binding.welcomingTxt.text = "Halo, ${user?.email}"

        val runAdapter = RunAdapter()

        // 🔥 tombol tambah
        binding.floatingBtnAddRun.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToAddRunFragment(null)
            )
        }

        // 🔥 tombol edit
        binding.btnEditMode.setOnClickListener {

            isEditMode = !isEditMode
            runAdapter.isEditMode = isEditMode

            if (isEditMode) {

                // edit mode aktif
                binding.btnEditMode.setTextColor(
                    android.graphics.Color.parseColor("#2563EB")
                )

                binding.btnEditMode.alpha = 0.7f

            } else {

                // normal mode
                binding.btnEditMode.setTextColor(
                    android.graphics.Color.parseColor("#2563EB")
                )

                binding.btnEditMode.alpha = 1f

                runAdapter.selectedRun = null
            }

            runAdapter.notifyDataSetChanged()
        }

        // 🔥 klik item saat edit
        runAdapter.onItemSelected = { run ->

            if (isEditMode) {

                android.app.AlertDialog.Builder(requireContext())
                    .setTitle("Pilih Aksi")
                    .setItems(arrayOf("Update", "Delete")) { _, which ->

                        when (which) {

                            // 🔥 UPDATE
                            0 -> {

                                // keluar edit mode
                                isEditMode = false
                                runAdapter.isEditMode = false
                                runAdapter.selectedRun = null

                                binding.btnEditMode.setTextColor(
                                    android.graphics.Color.parseColor("#2563EB")
                                )

                                binding.btnEditMode.alpha = 1f

                                runAdapter.notifyDataSetChanged()

                                findNavController().navigate(
                                    HomeFragmentDirections
                                        .actionHomeFragmentToAddRunFragment(run)
                                )
                            }

                            // 🔥 DELETE
                            1 -> {
                                android.app.AlertDialog.Builder(requireContext())
                                    .setTitle("Konfirmasi")
                                    .setMessage("Yakin mau hapus?")
                                    .setPositiveButton("Ya") { _, _ ->

                                        runViewModel.deleteRun(run)

                                        // popup berhasil
                                        android.widget.Toast.makeText(
                                            requireContext(),
                                            "Data berhasil dihapus",
                                            android.widget.Toast.LENGTH_SHORT
                                        ).show()

                                        // keluar edit mode
                                        isEditMode = false
                                        runAdapter.isEditMode = false
                                        runAdapter.selectedRun = null

                                        binding.btnEditMode.text = "Edit"
                                        binding.btnEditMode.setTextColor(
                                            android.graphics.Color.parseColor("#2563EB")
                                        )
                                        binding.btnEditMode.alpha = 1f

                                        runAdapter.notifyDataSetChanged()
                                    }
                                    .setNegativeButton("Batal", null)
                                    .show()
                            }
                        }
                    }
                    .show()
            }
        }

        // 🔥 recycler view
        binding.rvRunList.layoutManager =
            LinearLayoutManager(requireContext())

        runViewModel.runHistory.observe(viewLifecycleOwner) {
            runAdapter.setData(it)
        }

        binding.rvRunList.adapter = runAdapter

        return binding.root
    }
}