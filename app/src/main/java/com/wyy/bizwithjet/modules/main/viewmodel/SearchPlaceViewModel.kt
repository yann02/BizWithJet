package com.wyy.bizwithjet.modules.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.wyy.bizwithjet.common.base.viewmodels.BaseViewModel
import com.wyy.bizwithjet.common.base.models.HttpBaseBean
import com.wyy.bizwithjet.common.initiateRequest
import com.wyy.bizwithjet.modules.main.repository.SearchPlaceRepository

class SearchPlaceViewModel : BaseViewModel<SearchPlaceRepository>() {
    val mSearchPlacesData: MutableLiveData<HttpBaseBean> = MutableLiveData()

    fun searchPlaces(query: String) {
        initiateRequest({
            mSearchPlacesData.value = mRepository.searchPlaces()
        }, loadState)
    }
}