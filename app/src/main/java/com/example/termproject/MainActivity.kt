package com.example.termproject

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.termproject.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Gompei())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.gompei -> replaceFragment(Gompei())
                R.id.list -> replaceFragment(list())
                R.id.message -> replaceFragment(message())

                else ->{

                }
            }
            true

        }
       /** val berryButton = findViewById<ImageButton>(R.id.berryButton)
        val berryCounter = findViewById<TextView>(R.id.berryCounter)
        val berry = findViewById<ImageView>(R.id.berry)
        val heart = findViewById<ImageView>(R.id.heart)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        heart.setVisibility(View.INVISIBLE);

        progressBar.progress = 6;



        berryButton.setOnClickListener {
            var num = berryCounter.text.toString().toInt();
            if(num > 0){
                num = num - 1;
                berryCounter.text = num.toString();
                berry.setVisibility(View.VISIBLE);
                fadeOutAndHideImage(berry);
                heart.setVisibility(View.VISIBLE);
                bounceImage(heart);
                //bounceDown(heart);

            }
            else{
                Toast.makeText(this, "Send kind messages to your peers for more berries!", Toast.LENGTH_SHORT).show()
            }
        } **/
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout2, fragment)
        fragmentTransaction.commit()
    }

    private fun fadeOutAndHideImage(img: ImageView) {
        val fadeOut = AlphaAnimation(1F, 0F)
        fadeOut.setInterpolator(AccelerateInterpolator())
        fadeOut.setDuration(1200)

        fadeOut.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationEnd(animation:Animation) {
                img.setVisibility(View.GONE)
            }
            override fun onAnimationRepeat(animation:Animation) {}
            override  fun onAnimationStart(animation: Animation) {}
        })
        img.startAnimation(fadeOut)
    }

    private fun bounceImage(img: ImageView) {
        val translationYFrom = 70f
        val translationYTo = 150f
        val valueAnimator = ValueAnimator.ofFloat(translationYFrom, translationYTo).apply {
            interpolator = LinearInterpolator()
            duration = 500
        }
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            img?.translationY = value
        }
        valueAnimator.start()
        val translationYFrom2 = 150f
        val translationYTo2 = 70f
        val valueAnimator2 = ValueAnimator.ofFloat(translationYFrom2, translationYTo2).apply {
            interpolator = LinearInterpolator()
            duration = 500
        }
        valueAnimator2.addUpdateListener {
            val value = it.animatedValue as Float
            img?.translationY = value
        }
        valueAnimator2.start()
        fadeOutAndHideImage(img);
    }

    private fun bounceDown(img: ImageView) {
        val translationYFrom = 140f
        val translationYTo = 70f
        val valueAnimator = ValueAnimator.ofFloat(translationYFrom, translationYTo).apply {
            interpolator = LinearInterpolator()
            duration = 500
        }
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            img?.translationY = value
        }
        valueAnimator.start()
        val translationYFrom2 = 70f
        val translationYTo2 =140f
        val valueAnimator2 = ValueAnimator.ofFloat(translationYFrom2, translationYTo2).apply {
            interpolator = LinearInterpolator()
            duration = 500
        }
        valueAnimator2.addUpdateListener {
            val value = it.animatedValue as Float
            img?.translationY = value
        }
        valueAnimator2.start()

    }



}