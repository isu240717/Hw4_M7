package com.example.hw4_m7.statistic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw4_m7.R
import com.example.hw4_m7.data.StatisticModel
import com.example.hw4_m7.databinding.ItemStatisticsBinding

class StatisticAdapter(private val onClick: (statistic: StatisticModel) -> Boolean) :
    RecyclerView.Adapter<StatisticsViewHolder>() {

    private val list = arrayListOf<StatisticModel>()

    fun addStatistics(models: List<StatisticModel>) {
        list.clear()
        list.addAll(models)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        return StatisticsViewHolder(
            ItemStatisticsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) =
        holder.bind(list[position])

}

class StatisticsViewHolder(
    private val binding: ItemStatisticsBinding,
    private val onClick: (statistic: StatisticModel) -> Boolean
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(statistic: StatisticModel) = with(binding) {
        tvStatusInfo.text = statistic.status?.replace("Результат: ", "")
        tvDifficultyInfo.text = statistic.difficulty?.replace("Сложность: ", "")
        tvMistakesDetail.text = statistic.mistakes
        binding.imgIcon.setImageResource(if (statistic.status.equals("Победа")) R.drawable.ic_like else R.drawable.ic_dislike)
        imgDelete.setOnClickListener {
            onClick(statistic)
        }
    }

}
