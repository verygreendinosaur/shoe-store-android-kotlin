package com.verygreendinosaur.android.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {

    private val shoes = mutableListOf<Shoe>()

    var shoesLiveData: MutableLiveData<List<Shoe>> = MutableLiveData<List<Shoe>>()

    init {
        shoesLiveData.value = shoes
    }

    public fun add(shoe: Shoe) {
        shoes.add(shoe)
        shoesLiveData.value = shoes
    }

}