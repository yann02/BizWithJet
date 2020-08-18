package com.wyy.bizwithjet.utils

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration

private var sNoncompatDensity = 0f
private var sNoncompatScaledDensity = 0f

class DisplayUtil {
    /**
     * 适配：修改设备密度
     */
    companion object{
        @JvmStatic fun setCustomDensity(activity: Activity, application: Application) {
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
            val targetDensity = appDisplayMetrics.widthPixels / 360.toFloat()
            // 防止字体变小
            val targetScaleDensity =
                targetDensity * (sNoncompatScaledDensity / sNoncompatDensity)
            val targetDensityDpi = (160 * targetDensity).toInt()
            appDisplayMetrics.density = targetDensity
            appDisplayMetrics.scaledDensity = targetScaleDensity
            appDisplayMetrics.densityDpi = targetDensityDpi
            val activityDisplayMetrics = activity.resources.displayMetrics
            activityDisplayMetrics.density = targetDensity
            activityDisplayMetrics.scaledDensity = targetScaleDensity
            activityDisplayMetrics.densityDpi = targetDensityDpi
        }
    }
}