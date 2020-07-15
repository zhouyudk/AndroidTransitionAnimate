package com.zy.transitionanimate.scene

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.TextView
import com.zy.transitionanimate.R
import kotlinx.android.synthetic.main.activity_manual_scene.*

class ManualSceneActivity : AppCompatActivity() {

    val tvTitle: TextView by lazy {
        findViewById<TextView>(R.id.tv_text)
    }

    var isFirst: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_scene)
        initView()
    }

    fun initView() {
        val firstScene = Scene.getSceneForLayout(flContent, R.layout.layout_first_scene, this)
        val secondScene = Scene.getSceneForLayout(flContent, R.layout.layout_second_scene, this)

        tvTitle.setOnClickListener{
            if (isFirst) {
                TransitionManager.go(secondScene, Slide(Gravity.BOTTOM))
            }else{
                TransitionManager.go(firstScene, Slide(Gravity.BOTTOM))
            }
            isFirst=!isFirst
        }
    }
}
