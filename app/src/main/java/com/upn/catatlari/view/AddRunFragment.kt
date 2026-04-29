package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentAddRunBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel

class AddRunFragment : Fragment() {

    private lateinit var binding: FragmentAddRunBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveRun.setOnClickListener {
            val runDate = binding.etDate.text.toString()
            val runDuration = binding.etRunDuration.text.toString().toIntOrNull()
            val runDistance = binding.etRunDistance.text.toString().toIntOrNull()

            if (runDate.isBlank() || runDuration == null || runDistance == null) {
                Toast.makeText(requireContext(), "Data belum valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val runInput = Run(
                runDate = runDate,
                runDuration = runDuration,
                runDistance = runDistance
            )

            runViewModel.addRun(runInput)
            findNavController().popBackStack()
        }
    }
}