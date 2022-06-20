package com.tallercmovil.parametros2.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }

    val item_seleccionado = MutableLiveData<String>()

    val text: LiveData<String> = _text

    fun cambiaItem(item: String){
        item_seleccionado.postValue(item)
    }
}