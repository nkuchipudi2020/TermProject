package com.example.termproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelfCareActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var selfCareModelList : ArrayList<SelfCareTaskModel>
    private lateinit var selfCareBannerImageView : ImageView
    private lateinit var adapter : SelfCareTasksAdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selfCareBannerImageView = findViewById(R.id.selfCareBannerImageView)
        recyclerView = findViewById(R.id.selfCareTasksRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        selfCareModelList = setupModelList()
        adapter = SelfCareTasksAdapterClass(selfCareModelList, SelfCareTasksAdapterClass.OnClickListener { aTask ->
            Toast.makeText(this@SelfCareActivity, aTask.getTaskName(), Toast.LENGTH_SHORT).show()
        })
        recyclerView.adapter = adapter
//        submitbutton.setOnClickListener {
//            handleSubmit()
//            Toast.makeText(this@SelfCareActivity, "New note added", Toast.LENGTH_SHORT).show()
//            noteNameInput.text.clear()
//        }
    }

    private fun setupModelList():ArrayList<SelfCareTaskModel>{
        val noteModelListTemp = ArrayList<SelfCareTaskModel>()
        for (i in 1..21){
            noteModelListTemp.add(SelfCareTaskModel(false,"9/$i/2022"))
        }
        return noteModelListTemp
    }
}