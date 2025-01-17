package com.zy.transitionanimate

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.zy.transitionanimate.scene.ManualSceneActivity
import com.zy.transitionanimate.scene.SystemSceneActivity
import com.zy.transitionanimate.shareviewtransition.ShareViewFirstActivity

class MainActivity : AppCompatActivity() {

    val btnShareViewAnimate: Button by lazy {
        findViewById<Button>(R.id.btn_share_view_tran)
    }

    val btnSystemScene: Button by lazy {
        findViewById<Button>(R.id.btn_system_scene)
    }

    val btnManualScene: Button by lazy {
        findViewById<Button>(R.id.btn_manual_scene)
    }

    val testImage: ImageView by lazy {
        findViewById<ImageView>(R.id.iv_test)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postponeEnterTransition()
        initView()
    }

    fun initView() {
        btnShareViewAnimate.setOnClickListener {
            startActivity(Intent(this, ShareViewFirstActivity::class.java))
        }

        btnSystemScene.setOnClickListener{
            startActivity(Intent(this, SystemSceneActivity::class.java))
        }

        btnManualScene.setOnClickListener {
            startActivity(Intent(this, ManualSceneActivity::class.java))
        }
        testImage.setOnClickListener {
            (testImage.drawable as Animatable)?.let {
                it.start()
            }
        }
    }
}
