package com.example.android.intro.wwcandwtm

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_birthday.*

class BirthdayActivity : AppCompatActivity() {
    internal var user: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)


        val backgrounds = arrayOf(
                ContextCompat.getDrawable(this,R.drawable.sam_image)!!,
                ContextCompat.getDrawable(this,R.drawable.tabby_image)!!)
        val imageTransitionDrawable = TransitionDrawable(backgrounds)
        bdayImage.setImageDrawable(imageTransitionDrawable)

        changeBtn.setOnClickListener {
            if (!user) {
                animateNameText( "Tabby")
                imageTransitionDrawable.startTransition(1000)
                user = true
            } else {
                animateNameText("Samantha")
                imageTransitionDrawable.reverseTransition(1000)
                user = false
            }
        }
    }

    fun animateNameText(name : String){
        val anim = AlphaAnimation(1.0f, 0.0f)
        anim.duration = 500
        anim.repeatCount = 1
        anim.repeatMode = Animation.REVERSE

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) { }
            override fun onAnimationStart(animation: Animation?) { }
            override fun onAnimationRepeat(animation: Animation?) {
                nameText.text = name
            }
        })
        nameText.startAnimation(anim)
    }
}

