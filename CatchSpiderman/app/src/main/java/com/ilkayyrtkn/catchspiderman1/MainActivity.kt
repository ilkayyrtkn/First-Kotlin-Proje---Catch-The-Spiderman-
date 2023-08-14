package com.ilkayyrtkn.catchspiderman1


import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.ilkayyrtkn.catchspiderman1.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imageViews=ArrayList<ImageView>()
    private var score=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageViews.addAll(listOf(binding.imageView0,binding.imageView1, binding.imageView2,
            binding.imageView3,binding.imageView4,binding.imageView5,binding.imageView6,
            binding.imageView7, binding.imageView8))

        setImageViewClickListeners()
    }
    override fun onBackPressed() {
    }





    fun setImageViewClickListeners() {
        for (imageView in imageViews) {
            imageView.setOnClickListener {
                increaseScore()
            }
        }
    }
    fun increaseScore() {
        score++
        binding.scoreText.text = "Score: $score"
    }


    fun start(view: View) {
            object : CountDownTimer(10000, 500) {
                override fun onTick(p0: Long) {
                    val random = Random.Default
                    val randomIndex = random.nextInt(imageViews.size)
                    for (imageView in imageViews) {
                        imageView.visibility = View.INVISIBLE
                    }
                    binding.time1.text = "Left: ${p0 / 1000}"
                    binding.button.isEnabled = false
                    imageViews[randomIndex].visibility = View.VISIBLE
                }




                override fun onFinish() {
                    binding.time1.text = "Left: 0"
                    binding.button.isEnabled = true
                    val alertDialog = AlertDialog.Builder(this@MainActivity)
                        .setTitle("Süre Doldu")
                        .setMessage("Devam etmek istiyor musunuz?")
                        .setPositiveButton("Evet",DialogInterface.OnClickListener { dialogInterface, i ->

                        val intentFromMain=intent
                            finish()
                            startActivity(intent)
                        })


                        alertDialog.setNegativeButton("Hayır",DialogInterface.OnClickListener { dialogInterface, i ->
                            Toast.makeText(this@MainActivity,"Oyun Bitti!", Toast.LENGTH_LONG).show()
                            finish()

                        })
                            .setOnCancelListener {

                                Toast.makeText(this@MainActivity, "Oyun Bitti!", Toast.LENGTH_LONG).show()
                                finish()
                            }
                            .setCancelable(false)
                            .create()

                    alertDialog.show()
                }
            }.start()





        }







    }











