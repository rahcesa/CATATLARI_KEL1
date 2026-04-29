package com.upn.catatlari.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upn.catatlari.databinding.ItemRunBinding
import com.upn.catatlari.model.Run

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

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
        }
    }
}