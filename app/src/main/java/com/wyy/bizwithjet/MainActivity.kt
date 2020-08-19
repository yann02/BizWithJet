package com.wyy.bizwithjet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wyy.bizwithjet.databinding.ActivityMainBinding
import com.wyy.bizwithjet.utils.DisplayUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mWindowWidthDp: Int = 0
    private var mWindowHeightDp: Int = 0
    private var mWidthPx = 0
    private var mHeightPx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDhlAndZtl()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mWindowWidthDp = (1280.0 / resources.displayMetrics.density + 0.5).toInt()
        mWindowHeightDp = (800.0 / resources.displayMetrics.density + 0.5).toInt()
        mWidthPx = windowManager.defaultDisplay.width
        mHeightPx = windowManager.defaultDisplay.height
        binding.tvContent.text = "屏幕宽度是:$mWindowWidthDp dp，高度是：$mWindowHeightDp dp。$mWidthPx px, $mHeightPx px"
    }

    private fun setDhlAndZtl() {
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}
