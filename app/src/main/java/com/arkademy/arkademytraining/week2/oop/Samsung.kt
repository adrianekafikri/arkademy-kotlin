package com.arkademy.arkademytraining.week2.oop

/**
 * Created by adrianfikri on 2020-01-28.
 */
class Samsung : Phone(), InputChargeListener, VolumeListener, ScreenListener {

    override fun volumeDown() {
        print(volume)
    }



    override fun homeButton() {

    }

    override fun volumeButton() {

    }

    override fun chargeInput() {

    }

    override fun onCharge() {

    }

    override fun onVolumeUp() {

    }

    override fun onVolumeDown() {

    }

    override fun onSwipe() {

    }


}