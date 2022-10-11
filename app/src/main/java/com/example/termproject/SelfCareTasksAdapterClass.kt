package com.example.termproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.termproject.models.Property

class SelfCareTasksAdapterClass(private val data : List<Property>, private val onClickListener: OnClickListener) : RecyclerView.Adapter<SelfCareTasksAdapterClass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.self_care_tasks_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], holder)
        /** val itemModel = mList[position]

        holder.taskName.text = itemModel.getTaskName()
        holder.itemView.setOnClickListener{
            onClickListener.onClick(itemModel)
        } **/
    }

    override fun getItemCount(): Int {
        return data.size
    }

    // ViewHolder that for individual zodiac symbols
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  taskName: TextView = itemView.findViewById(R.id.task_text)
        fun bind(property: Property, holder: ViewHolder){
            holder.taskName.text = property.task

        }
    }

    class OnClickListener(val clickListener: (selfCareItem: SelfCareTaskModel) -> Unit) {
        fun onClick(selfCareItem: SelfCareTaskModel) = clickListener(selfCareItem)
    }
}
