package com.wyy.bizwithjet.common.base.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wyy.bizwithjet.common.base.repositorys.BaseRepository
import com.wyy.bizwithjet.common.state.State
import com.wyy.bizwithjet.common.utils.CommonUtil

/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @CreateDate: 2020/6/3 22:51
 */
open class BaseViewModel<T : BaseRepository> : ViewModel(){
    val loadState by lazy {
        MutableLiveData<State>()
    }

    val mRepository : T by lazy {
        (CommonUtil.getClass<T>(this))
            .getDeclaredConstructor(MutableLiveData::class.java)
            .newInstance(loadState)
    }

    override fun onCleared() {
        super.onCleared()
        mRepository.unSubscribe()
    }
}
