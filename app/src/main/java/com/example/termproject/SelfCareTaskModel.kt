package com.example.termproject

data class SelfCareTaskModel(private var completeCheck: Boolean, private val taskName: String) {

    fun getCompleteStatus() : Boolean {
        return completeCheck
    }

    fun getTaskName() : String {
        return taskName
    }

    fun toggleTaskComplete() {
        completeCheck = !completeCheck
    }

}