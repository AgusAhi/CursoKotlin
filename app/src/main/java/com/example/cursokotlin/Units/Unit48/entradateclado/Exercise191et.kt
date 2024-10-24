package com.example.cursokotlin.Units.Unit47.entradateclado

class ComposableInput {
    fun retornarInt(value: String): Int? {
        return try {
            value.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun retornarDouble(value: String): Double? {
        return try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun retornarFloat(value: String): Float? {
        return try {
            value.toFloat()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun validateIntInput(value: String, onResult: (Int?) -> Unit) {
        val result = retornarInt(value)
        onResult(result)
    }

    fun validateDoubleInput(value: String, onResult: (Double?) -> Unit) {
        val result = retornarDouble(value)
        onResult(result)
    }

    fun validateFloatInput(value: String, onResult: (Float?) -> Unit) {
        val result = retornarFloat(value)
        onResult(result)
    }
}