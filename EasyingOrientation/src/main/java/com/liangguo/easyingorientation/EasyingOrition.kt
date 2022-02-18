package com.liangguo.easyingorientation

import android.content.Context
import android.util.Log
import android.view.OrientationEventListener
import androidx.lifecycle.*


/**
 * @author ldh
 * 时间: 2022/2/18 13:01
 * 邮箱: 2637614077@qq.com
 */

internal typealias OrientationCallback = (OrientationState) -> Unit

object EasyingOrition {

    const val DefaultAngleThreshold = 20


    fun listenOnOrientationChanged(
        context: Context,
        lifecycleOwner: LifecycleOwner,
        angleThreshold: Int = DefaultAngleThreshold,
        callback: OrientationCallback
    ) {
        val currentState = MutableLiveData<OrientationState>()
        val orientationListener = object : OrientationEventListener(context) {
            override fun onOrientationChanged(orientation: Int) {
                if (orientation != ORIENTATION_UNKNOWN) {
                    calculateState(orientation, angleThreshold)?.let {
                        Log.e("方向", it.toString())
                        if (currentState.value != it) {
                            currentState.value = it
                        }
                    }
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_RESUME) {
                    orientationListener.enable()
                } else if (event == Lifecycle.Event.ON_PAUSE) {
                    orientationListener.disable()
                }
            }
        })
        currentState.observe(lifecycleOwner, Observer {
            callback(it)
        })
    }

    /**
     * 通过方向的数据计算当前应该在什么状态
     * @return 方向状态，如果是空则表示暂时不改变
     */
    private fun calculateState(orientation: Int, angleThreshold: Int): OrientationState? {
        return if (orientation > 360 - angleThreshold || orientation < angleThreshold) OrientationState.Portrait
        else if (orientation > 90 - angleThreshold && orientation < 90 + angleThreshold) OrientationState.Landscape
        else if (orientation > 180 - angleThreshold && orientation < 180 + angleThreshold) OrientationState.PortraitReverse
        else if (orientation > 270 - angleThreshold && orientation < 270 + angleThreshold) OrientationState.LandscapeReverse
        else null
    }


}
