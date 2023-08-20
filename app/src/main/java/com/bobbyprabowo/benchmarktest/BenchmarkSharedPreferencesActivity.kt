package com.bobbyprabowo.benchmarktest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bobbyprabowo.benchmarktest.databinding.ActivityBenchmarkSharedPreferencesBinding
import com.bobbyprabowo.benchmarktest.databinding.ActivityMainBinding

class BenchmarkSharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBenchmarkSharedPreferencesBinding.inflate(layoutInflater)
        binding.startWriteBenchmarkButton.setOnClickListener {
            startBenchmark()
        }
        setContentView(binding.root)
    }

    private fun startBenchmark() {
        val sharedPref = getSharedPreferences("benchmark-app", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            (1..100).forEach {
                putString("key + ${it.toString()}", it.toString())
            }
            apply()
        }
        Toast.makeText(this, "write 100 setString", Toast.LENGTH_LONG).show()
    }

}
