package com.liangguo.easyingorientation


/**
 * @author ldh
 * 时间: 2022/2/18 13:07
 * 邮箱: 2637614077@qq.com
 *
 * 屏幕朝向状态
 */
sealed interface OrientationState {

    object Portrait: OrientationState {
        override val oritation: Int
            get() = 0
    }

    object PortraitReverse: OrientationState {
        override val oritation: Int
            get() = 180
    }

    object Landscape: OrientationState {
        override val oritation: Int
            get() = 90
    }

    object LandscapeReverse: OrientationState {
        override val oritation: Int
            get() = 270
    }


    /**
     * 屏幕朝向状态对应的角度
     */
    val oritation: Int

}
