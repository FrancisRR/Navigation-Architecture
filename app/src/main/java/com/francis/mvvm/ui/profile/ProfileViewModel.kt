package com.francis.mvvm.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {



    public fun getActionList(): MutableLiveData<ArrayList<ProfileAction>>? {
        var mutableLiveData: MutableLiveData<ArrayList<ProfileAction>>? = MutableLiveData()
        var returlList: ArrayList<ProfileAction>? = arrayListOf()
        returlList?.add(ProfileAction(1, "Personal Details"))
        returlList?.add(ProfileAction(2, "Account Details"))
        returlList?.add(ProfileAction(3, "Currency"))
        returlList?.add(ProfileAction(4, "Language"))
        mutableLiveData?.value = returlList
        return mutableLiveData
    }


}