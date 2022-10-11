package com.example.termproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val EXTRA_ARRAY_LOCATION: String = "TASKLIST_ARRAY_LOCATION"
private const val EXTRA_STATUS: String = "CHECKBOX_STATUS"
private const val EXTRA_RETURN_STATUS: String = "CHECKBOX_STATUS_RETURN"
private const val EXTRA_TASK_INFO: String = "TASK_INFORMATION"
private const val LAUNCH_CHILD_FOR_RES: Int = 1

class SelfCareActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var selfCareModelList : ArrayList<SelfCareTaskModel>
    private lateinit var selfCareBannerImageView : ImageView
    private lateinit var adapter : SelfCareTasksAdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selfCareBannerImageView = findViewById(R.id.selfCareBannerImageView)
        recyclerView = findViewById(R.id.selfCareTasksRecyclerView)
        setContentView(R.layout.activity_main)
        selfCareModelList = setupModelList()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter = SelfCareTasksAdapterClass(selfCareModelList, SelfCareTasksAdapterClass.OnClickListener { aTask ->
            Toast.makeText(this@SelfCareActivity, aTask.getTaskName(), Toast.LENGTH_SHORT).show()
            intent = Intent(this@SelfCareActivity, SelfCareActivity::class.java)
            intent.putExtra(EXTRA_STATUS, aTask.getCompleteStatus())
            intent.putExtra(EXTRA_TASK_INFO, aTask.getTaskName())
            intent.putExtra(EXTRA_ARRAY_LOCATION, getArrayLocation(aTask))
            startActivityForResult(intent, LAUNCH_CHILD_FOR_RES)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (resultCode == RESULT_OK){
//            val indexOfLikedItem =  data?.extras?.get(EXTRA_ARRAY_LOCATION) as Int
//            recyclerView[indexOfLikedItem].findViewById<CheckBox>(R.id.task_checkbox).isChecked =
//                data.extras?.get(EXTRA_RETURN_STATUS) as Boolean
//            selfCareModelList[indexOfLikedItem].toggleTaskComplete()
//        }
        val indexOfLikedItem =  data?.extras?.get(EXTRA_ARRAY_LOCATION) as Int
        selfCareModelList[indexOfLikedItem].toggleTaskComplete()
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun getArrayLocation(aTask: SelfCareTaskModel):Int{
        Log.println(Log.INFO,"TASK_LOCATION",recyclerView.size.toString())
        for (i in selfCareModelList.indices){
            if (aTask == selfCareModelList[i]) {
                return i
            }
        }
        return -1
    }

    private fun setupModelList():ArrayList<SelfCareTaskModel>{
        val noteModelListTemp = ArrayList<SelfCareTaskModel>()
        noteModelListTemp.add(SelfCareTaskModel(false,"test1"))
        noteModelListTemp.add(SelfCareTaskModel(false,"test2"))
        noteModelListTemp.add(SelfCareTaskModel(false,"test3"))
        return noteModelListTemp
    }
}