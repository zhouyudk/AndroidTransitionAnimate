package com.zy.transitionanimate.shareviewtransition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.zy.transitionanimate.R

class ShareViewSecondActivity : AppCompatActivity() {
    private val ivImage: ImageView by lazy {
        findViewById<ImageView>(R.id.iv_image)
    }
    val imageUrl = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1594782523&di=ab9d225b69b06b5b266fabb20b014204&src=http://i1.hdslb.com/bfs/archive/0720bad32399fc62a6557abf720e2da6db92c932.png"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_view_second)
        initView()
    }

    fun initView() {
        ivImage.setOnClickListener {
            finishAfterTransition()
        }

        Glide.with(this)
            .asBitmap()
            .load(imageUrl)
            .placeholder(R.drawable.test)
            .error(R.drawable.test)
            .into(ivImage)
    }
}
