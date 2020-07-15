package com.zy.transitionanimate.shareviewtransition

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.zy.transitionanimate.R

class ShareViewFirstActivity : AppCompatActivity() {

    private val ivImage: ImageView by lazy {
        findViewById<ImageView>(R.id.iv_image)
    }
    val imageUrl = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1594782523&di=ab9d225b69b06b5b266fabb20b014204&src=http://i1.hdslb.com/bfs/archive/0720bad32399fc62a6557abf720e2da6db92c932.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_view_first)
        initView()
    }

    fun initView() {
        ivImage.setOnClickListener {
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this, ivImage, "activityTransform").toBundle()
            startActivity(Intent(this, ShareViewSecondActivity::class.java),bundle)
        }

        Glide.with(this)
            .asBitmap()
            .load(imageUrl)
            .listener(object : RequestListener<Bitmap> {
                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    startPostponedEnterTransition()
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    startPostponedEnterTransition()
                    return false
                }
            })
            .placeholder(R.drawable.test)
            .error(R.drawable.test)
            .into(ivImage)
    }
}
