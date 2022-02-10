package com.example.app3.basic_menu

import android.graphics.Bitmap
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.function.BinaryOperator

open class DataPlayMenu:ViewModel() {
    val nameP: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val imId: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val Cup:MutableLiveData<Achivement_Item> by lazy {
        MutableLiveData<Achivement_Item>()
    }

    val AchivementScrinshot:MutableLiveData<Bitmap> by lazy {
        MutableLiveData<Bitmap>()
    }
    val active:MutableLiveData<View> by lazy {
        MutableLiveData<View>()
    }


}