package com.bobbyprabowo.benchmarktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bobbyprabowo.benchmarktest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.sharedPrefButton.setOnClickListener {
            val intent = Intent(this, BenchmarkSharedPreferencesActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }
}
