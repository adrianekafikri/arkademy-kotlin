package com.arkademy.arkademytraining.week2.oop

/**
 * Created by adrianfikri on 2020-01-26.
 * Polymorphism concept
 */
interface Shape {

    fun calculate()
    fun calculate(isArea: Boolean)

    class Circle: Shape {

        override fun calculate() { //overriding

        }

        override fun calculate(isArea: Boolean) { //overloading

        }
    }

    class Triangle: Shape {

        override fun calculate() {

        }

        override fun calculate(isArea: Boolean) { //overloading

        }
    }

    class Rectangle: Shape {

        override fun calculate() {

        }

        override fun calculate(isArea: Boolean) { //overloading

        }
    }
}