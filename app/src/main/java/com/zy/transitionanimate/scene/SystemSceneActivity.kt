package com.zy.transitionanimate.scene

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.RelativeLayout
import com.zy.transitionanimate.R
import com.zy.transitionanimate.dpToPx

class SystemSceneActivity : AppCompatActivity() {

    val vSquare: View by lazy {
        findViewById<View>(R.id.v_square)
    }

    val sceneRoot: RelativeLayout by lazy {
        findViewById<RelativeLayout>(R.id.scene_root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_scene)
        initView()
    }

    fun initView() {
        vSquare.setOnClickListener {
            TransitionManager.beginDelayedTransition(sceneRoot)
            vSquare.layoutParams.apply {
                if (width == resources.dpToPx(100).toInt()) {
                    width = resources.dpToPx(260).toInt()
                    height = resources.dpToPx(260).toInt()
                } else {
                    width = resources.dpToPx(100).toInt()
                    height = resources.dpToPx(100).toInt()
                }

            }.also {
                vSquare.layoutParams = it
            }
        }
    }
}
