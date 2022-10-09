package com.example.termproject

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Gompei.newInstance] factory method to
 * create an instance of this fragment.
 */
class Gompei : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        val berryButton = view.findViewById<ImageButton>(R.id.berryButton)
        val berryCounter = view.findViewById<TextView>(R.id.berryCounter)
        val berry = view.findViewById<ImageView>(R.id.berry)
        val heart = view.findViewById<ImageView>(R.id.heart)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
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
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gompei, container, false)
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Gompei.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Gompei().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun fadeOutAndHideImage(img: ImageView) {
        val fadeOut = AlphaAnimation(1F, 0F)
        fadeOut.setInterpolator(AccelerateInterpolator())
        fadeOut.setDuration(1200)

        fadeOut.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                img.setVisibility(View.GONE)
            }
            override fun onAnimationRepeat(animation: Animation) {}
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