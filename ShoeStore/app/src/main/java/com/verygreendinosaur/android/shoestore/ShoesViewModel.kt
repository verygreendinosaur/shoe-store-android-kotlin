package com.verygreendinosaur.android.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel: ViewModel() {

    var shoesLiveData: MutableLiveData<List<Shoe>> = MutableLiveData<List<Shoe>>()

    private val shoes = mutableListOf<Shoe>(
        Shoe("HyperFlex", "ABIBAS", 10.0,"Super chunky throwback kicks - black/white"),
        Shoe("HyperFlex-2", "ABIBAS", 9.5,"Super chunky throwback kicks - purple/white"),
        Shoe("Iron Toe Oxford Boots", "Red Feather", 9.0,"Super chunky throwback kicks - purple/white"),
        Shoe("HyperFlex-Seattles", "ABIBAS", 9.5,"Super chunky throwback kicks - Seattle green & blue edition"),
        Shoe("Ghost Nines", "Brooms", 10.0,"Super cushioned endurance runners - midnight blue"),
        Shoe("Ghost Tens Trails", "Brooms", 10.0,"Super cushioned endurance trail runners w/ waterproof mesh - digital camo"),
    )

    init {
        shoesLiveData.value = shoes
    }

    public fun add(shoe: Shoe) {
        shoes.add(shoe)
        shoesLiveData.value = shoes
    }

}