package com.wyy.bizwithjet.common.callback

import com.kingja.loadsir.callback.Callback
import com.wyy.bizwithjet.R

/**
 * Created with Android Studio.
 * Description:
 * @author: 王拣贤
 * @date: 2020/06/03
 * Time: 14:29
 */
class ErrorCallBack : Callback() {
    override fun onCreateView(): Int = R.layout.layout_error
}