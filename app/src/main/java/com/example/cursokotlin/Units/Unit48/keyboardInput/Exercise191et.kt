package com.example.cursokotlin.Units.Unit48.entradateclado

class ComposableInput {
    fun returnInt(value: String): Int? {
        return try {
            value.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun returnDouble(value: String): Double? {
        return try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun returnFloat(value: String): Float? {
        return try {
            value.toFloat()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun validateIntInput(value: String, onResult: (Int?) -> Unit) {
        val result = returnInt(value)
        onResult(result)
    }

    fun validateDoubleInput(value: String, onResult: (Double?) -> Unit) {
        val result = returnDouble(value)
        onResult(result)
    }

    fun validateFloatInput(value: String, onResult: (Float?) -> Unit) {
        val result = returnFloat(value)
        onResult(result)
    }
}