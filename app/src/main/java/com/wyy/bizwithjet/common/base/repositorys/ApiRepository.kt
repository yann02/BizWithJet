package com.wyy.bizwithjet.common.base.repositorys

import com.wyy.bizwithjet.network.ApiService
import com.wyy.bizwithjet.network.RetrofitFactory


/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @CreateDate: 2020/6/3 22:54
 */
abstract class ApiRepository : BaseRepository() {
    protected val apiService: ApiService by lazy {
        RetrofitFactory.instance.createRetrofit(ApiService::class.java)
    }
}