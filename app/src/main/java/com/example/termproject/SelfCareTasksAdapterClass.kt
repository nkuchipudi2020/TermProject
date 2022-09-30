package com.example.termproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelfCareTasksAdapterClass(private var mList: ArrayList<SelfCareTaskModel>, private val onClickListener: OnClickListener) : RecyclerView.Adapter<SelfCareTasksAdapterClass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.self_care_tasks_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = mList[position]
        holder.taskName.text = itemModel.getTaskName()
        holder.itemView.setOnClickListener{
            onClickListener.onClick(itemModel)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // ViewHolder that for individual zodiac symbols
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  taskName: TextView = itemView.findViewById(R.id.task_text)
    }

    class OnClickListener(val clickListener: (selfCareItem: SelfCareTaskModel) -> Unit) {
        fun onClick(selfCareItem: SelfCareTaskModel) = clickListener(selfCareItem)
    }
}
