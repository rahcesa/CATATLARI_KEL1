package com.upn.catatlari.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upn.catatlari.databinding.ItemRunBinding
import com.upn.catatlari.model.Run

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {
    var isEditMode = false
    var selectedRun: Run? = null
    var onItemSelected: ((Run) -> Unit)? = null

    private val runList = mutableListOf<Run>()

    fun setData(runItems: List<Run>) {
        runList.clear()
        runList.addAll(runItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        val binding = ItemRunBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RunViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        holder.bind(runList[position])
    }

    override fun getItemCount(): Int {
        return runList.size
    }

    inner class RunViewHolder(private val binding: ItemRunBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(run: Run) {
            binding.txtRunDate.text = run.runDate
            binding.txtRunDistance.text = "${run.runDistance} meter"
            binding.txtRunDuration.text = "${run.runDuration} menit"

            itemView.setOnClickListener {
                if (isEditMode) {
                    selectedRun = run
                    onItemSelected?.invoke(run)
                    notifyDataSetChanged()
                }
            }

            // efek item dipilih
            if (isEditMode) {

                if (run == selectedRun) {
                    binding.cardRun.alpha = 0.7f
                    binding.cardRun.scaleX = 0.97f
                    binding.cardRun.scaleY = 0.97f
                } else {
                    binding.cardRun.alpha = 1f
                    binding.cardRun.scaleX = 1f
                    binding.cardRun.scaleY = 1f
                }

            } else {

                binding.cardRun.alpha = 1f
                binding.cardRun.scaleX = 1f
                binding.cardRun.scaleY = 1f
            }
        }
    }
}