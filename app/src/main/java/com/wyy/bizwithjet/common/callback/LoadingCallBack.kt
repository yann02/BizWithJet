package com.wyy.bizwithjet.common.callback

import com.kingja.loadsir.callback.Callback
import com.wyy.bizwithjet.R

/**
 * Created with Android Studio.
 * Description:
 * @author: 王拣贤
 * @date: 2020/06/03
 * Time: 14:37
 */
class LoadingCallBack : Callback() {
    override fun onCreateView(): Int = R.layout.layout_loading
}