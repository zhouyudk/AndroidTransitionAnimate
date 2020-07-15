package com.zy.transitionanimate

import android.content.res.Resources

fun Resources.resToPx(resId: Int): Float {
    return getDimension(resId)
}

fun Resources.dpToPx(dp: Int): Float {
    return (dp * displayMetrics.density)
}

fun Resources.dpToPx(dp: Float): Float {
    return (dp * displayMetrics.density)
}

fun Resources.pxToDp(px: Int): Float {
    return (px / displayMetrics.density)
}

fun Resources.pxToDp(px: Float): Float {
    return (px / displayMetrics.density)
}