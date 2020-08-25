package com.wyy.bizwithjet.modules.main.view

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.wjx.android.weather.base.view.BaseLifeCycleActivity
import com.wyy.bizwithjet.R
import com.wyy.bizwithjet.common.requestByPermissionOnActivity
import com.wyy.bizwithjet.databinding.ActivityMenuDataBinding
import com.wyy.bizwithjet.modules.main.viewmodel.SearchPlaceViewModel

class MenuDataActivity : BaseLifeCycleActivity<SearchPlaceViewModel, ActivityMenuDataBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestByPermissionOnActivity({mViewModel.searchPlaces("")},this, listOf(Manifest.permission.INTERNET))
    }

    override fun getLayoutId() = R.layout.activity_menu_data

    override fun initDataObserver() {
        super.initDataObserver()
        mViewModel.mSearchPlacesData.observe(this, Observer {
            Log.d("wyy", "it.bodyContent=${it?.bodyContent}")
        })
    }
}
