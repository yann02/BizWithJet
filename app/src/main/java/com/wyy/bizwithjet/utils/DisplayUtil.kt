package com.wyy.bizwithjet.utils

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration

private var sNoncompatDensity = 0f
private var sNoncompatScaledDensity = 0f
private const val NORMAL_DPI = 160
private const val NORMAL_DP_HEIGHT = 400
private const val NORMAL_DP_WIDTH = 360

/**
 * 适配：修改设备密度density
 * Create by wyy on 2020/08/19
 * 用法：
 * 1.确定要保持宽还是高的最大dp不变
 * 2、传入宽或者高的最大dp值
 */
class DisplayUtil {

    companion object {
        /**
         * 设备宽度360dp
         * 保持屏幕宽度的dp不变，修改设备density
         */
        @JvmStatic
        fun setCustomDensityNormal(activity: Activity, application: Application) {
            setCustomDensity(activity, application, EnumDirector.WIDTH, NORMAL_DP_WIDTH)
        }

        /**
         * @param normalMaxWidthDp 设备屏幕宽度（dp）
         * 保持设备屏幕宽度dp不变
         */
        @JvmStatic
        fun setCustomDensityByWidth(activity: Activity, application: Application, normalMaxWidthDp: Int = NORMAL_DP_WIDTH) {
            setCustomDensity(activity, application, EnumDirector.WIDTH, normalMaxWidthDp)
        }

        /**
         * @param normalMaxHeightDp 设备屏幕高度（dp）
         * 保持设备屏幕高度dp不变
         */
        @JvmStatic
        fun setCustomDensityByHeight(activity: Activity, application: Application, normalMaxHeightDp: Int = NORMAL_DP_HEIGHT) {
            setCustomDensity(activity, application, EnumDirector.HEIGHT, normalMaxHeightDp)
        }

        /**
         * 公共实现方法
         */
        @JvmStatic
        fun setCustomDensity(activity: Activity, application: Application, mEnumDirector: EnumDirector, dp: Int) {
            val appDisplayMetrics = application.resources.displayMetrics
            if (sNoncompatDensity == 0f) {
                sNoncompatDensity = appDisplayMetrics.density
                sNoncompatScaledDensity = appDisplayMetrics.scaledDensity
                // 防止系统切换后不起作用
                application.registerComponentCallbacks(object : ComponentCallbacks {
                    override fun onLowMemory() {}
                    override fun onConfigurationChanged(newConfig: Configuration) {
                        if (newConfig.fontScale > 0) {
                            sNoncompatScaledDensity =
                                application.resources.displayMetrics.scaledDensity
                        }
                    }
                })
            }
            val mPx = when (mEnumDirector) {
                EnumDirector.WIDTH -> appDisplayMetrics.widthPixels
                EnumDirector.HEIGHT -> appDisplayMetrics.heightPixels
            }
            val targetDensity = mPx / dp.toFloat()
            // 防止字体变小
            val targetScaleDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity)
            val targetDensityDpi = (NORMAL_DPI * targetDensity).toInt()
            appDisplayMetrics.density = targetDensity
            appDisplayMetrics.scaledDensity = targetScaleDensity
            appDisplayMetrics.densityDpi = targetDensityDpi
            val activityDisplayMetrics = activity.resources.displayMetrics
            activityDisplayMetrics.density = targetDensity
            activityDisplayMetrics.scaledDensity = targetScaleDensity
            activityDisplayMetrics.densityDpi = targetDensityDpi
        }
    }

    /**
     * 定义屏幕方向的枚举
     */
    enum class EnumDirector {
        WIDTH, HEIGHT
    }
}