package com.example.termproject

data class SelfCareTaskModel(private val completeCheck: Boolean) {

    fun getCompleteStatus() : Boolean {
        return completeCheck
    }

}