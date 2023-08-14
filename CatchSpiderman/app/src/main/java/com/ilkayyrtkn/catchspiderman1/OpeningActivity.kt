package com.ilkayyrtkn.catchspiderman1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.ilkayyrtkn.catchspiderman1.databinding.ActivityOpeningBinding

class OpeningActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOpeningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpeningBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text="Ben Spiderman beni yakalayabilmeyi düşünüyor musun? düşünüyorsan gelde " +
                "yakala hiçte kolay alacağını sanma. "+
                "Hazırsan başlayalım."
    }
fun startbutton(view: View) {
    val intent=Intent(this@OpeningActivity,MainActivity::class.java)
    startActivity(intent)
    finish()
}


}