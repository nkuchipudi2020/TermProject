package com.example.termproject

data class SelfCareTaskModel(private val completeCheck: Boolean, private val taskName: String) {

    fun getCompleteStatus() : Boolean {
        return completeCheck
    }

    fun getTaskName() : String {
        return taskName
    }

}