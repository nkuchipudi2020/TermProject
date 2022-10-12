package com.example.termproject

import android.content.Context
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.termproject.models.PostModel
import com.example.termproject.network.ServiceGenerator


class PostAdapter(val postModel: MutableList<PostModel>): RecyclerView.Adapter<PostViewHolder>() {
    private var deliveryNotesModels = mutableListOf<PostModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_post, parent, false)
        val sharedPreference =  view.getContext().getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.findViewById<CheckBox>(R.id.task_checkbox).setOnCheckedChangeListener(null)
        holder.itemView.findViewById<CardView>(R.id.task_card).setOnLongClickListener(null)
        return holder.bindView(postModel[position],deliveryNotesModels)
    }


    override fun getItemCount(): Int {
        return postModel.size
    }
}

class PostViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){



    private val task_title: TextView = itemView.findViewById(R.id.task_title)
    private val task_check : CheckBox = itemView.findViewById(R.id.task_checkbox)
//    private val task_card : CardView = itemView.findViewById(R.id.task_card)

    fun bindView(postModel : PostModel, list : MutableList<PostModel> ){
        task_title.text = postModel.task
        task_check.isChecked = list.contains(postModel)

        task_check.setOnCheckedChangeListener { _, isChecked ->
            //TODO:  Insert PUT code here
            // url + /whatever the id is
            // PUT request with body = { "task": "taskname" , "done":isChecked}
//            val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
//            val call = serviceGenerator.putRequest()

            println(isChecked)
            if (isChecked) {
                // Send a Put request to server, to change Tasks done status
                if (!list.contains(postModel))
                    list.add(postModel)
            } else {
                //task_check.isChecked = false
                list.remove(postModel)
            }
        }
    }
}