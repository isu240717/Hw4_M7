package com.example.hw4_m7.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.hw4_m7.data.StatisticModel
import com.example.hw4_m7.databinding.ActivityMainBinding
import com.example.hw4_m7.statistic.StatisticActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnFirst.setOnClickListener {
            val data = StatisticModel(
                status = binding.spinner.selectedItem.toString(),
                difficulty = binding.spinnerTwo.selectedItem.toString(),
                mistakes = binding.etFirst.text.toString(),
            )
            if (binding.etFirst.text!!.isEmpty() || binding.etSecond.text!!.isEmpty()) {
                Toast.makeText(this, "Вводите значения в поля", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addStatistic(data).observe(this){
                    if (it != -1L){
                        Toast.makeText(this, "Данные успешно добавились", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Ошибка! Данные не были добавилены", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.btnSecond.setOnClickListener {
            val intent = Intent(this,StatisticActivity::class.java)
            startActivity(intent)
        }
    }
}

