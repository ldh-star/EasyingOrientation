package com.liangguo.easyingorientation

import androidx.fragment.app.FragmentActivity


/**
 * @author ldh
 * 时间: 2022/2/18 14:23
 * 邮箱: 2637614077@qq.com
 */

/**
 * 监听手机方向旋转事件
 * @param angleThreshold 改变屏幕朝向的阈值
 * @param callback 监听的回调
 */
fun FragmentActivity.listenOnOrientationChanged(
    angleThreshold: Int = EasyingOrition.DefaultAngleThreshold,
    callback: OrientationCallback
) {
    EasyingOrition.listenOnOrientationChanged(this, this, angleThreshold, callback)
}
