package com.arkademy.arkademytraining.week2.oop

/**
 * Created by adrianfikri on 2020-01-26.
 * Abstraction concept
 */
abstract class Phone {

    var volume = 0

    abstract fun homeButton()
    abstract fun volumeButton()
    abstract fun chargeInput()

    abstract fun volumeDown()

    private fun shutVolume() {
        volumeDown()
    }
}

interface InputChargeListener {
    fun onCharge()
}

interface VolumeListener {
    fun onVolumeUp()
    fun onVolumeDown()
}

interface ScreenListener {
    fun onSwipe()
}