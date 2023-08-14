package com.zzs.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.zzs.learn.MyApp.Companion.FLUTTER_ENGINE_ID
import com.zzs.learn.databinding.ActivityMainBinding
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnOpenFlutter.setOnClickListener {
            openFlutter()
            Toast.makeText(MainActivity@this,"123233", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openFlutter() {
        startActivity(
            FlutterActivity.withCachedEngine(FLUTTER_ENGINE_ID)
                .build(this)
        )
    }
}