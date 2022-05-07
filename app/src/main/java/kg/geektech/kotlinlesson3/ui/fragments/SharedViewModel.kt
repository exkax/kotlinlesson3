package kg.geektech.kotlinlesson3.ui.fragments

import android.graphics.Picture
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.geektech.kotlinlesson3.base.BaseViewModel
import kg.geektech.kotlinlesson3.data.model.Model

class SharedViewModel : BaseViewModel() {
    private val _listState = MutableLiveData<List<Model>>()
    var listState: LiveData<List<Model>> = _listState

    fun putPicture(list: List<Model>) {
        _listState.postValue(list)
    }

}