package com.wyy.bizwithjet.common.callback

import com.kingja.loadsir.callback.Callback
import com.wyy.bizwithjet.R

/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @date: 2020/06/03
 * Time: 19:26
 */

class EmptyCallBack : Callback() {
    override fun onCreateView(): Int = R.layout.layout_empty
}