package com.arkademy.arkademytraining.week2.oop

/**
 * Created by adrianfikri on 2020-01-26.
 * Encapsulation concept
 */
class Cat {

    private var mood = 0
    private var hungry = 0
    private var energy = 0

    private fun meow() {
        print("Meow!")
    }

    fun sleep() {
        energy++
        hungry++
    }

    fun play() {
        mood++
        energy--
        meow()
    }

    fun feed() {
        hungry--
        mood++
        meow()
    }
}