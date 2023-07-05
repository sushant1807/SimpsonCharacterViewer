package com.sushant.simpsoncharacterviewer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sushant.simpsoncharacterviewer.R
import com.sushant.simpsoncharacterviewer.model.RelatedTopic

class SimpsonsViewAdapter(private val listener: SimpsonItemListener) :
    RecyclerView.Adapter<SimpsonViewHolder>() {

    interface SimpsonItemListener {
        fun onClickedSimpsonItem(relatedTopic: RelatedTopic)
    }

    private var items = ArrayList<RelatedTopic>()

    fun setSimpsonsData(cityModelList: List<RelatedTopic>) {
        this.items.clear()
        this.items = cityModelList.toMutableList() as ArrayList<RelatedTopic>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpsonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.simpsons_list_item, parent, false)
        return SimpsonViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpsonViewHolder, position: Int) {
        val blog = items[position]
        holder.textTitle.text =
            blog.text?.substringBefore(delimiter = "-", missingDelimiterValue = "name Not Found")
                ?: ""
        holder.textDescription.text =
            blog.text?.substringAfter(delimiter = "-", missingDelimiterValue = "name Not Found")
                ?: ""
        Glide.with(holder.itemLayout).load(blog.icon!!.url)
            .placeholder(R.drawable.person)
            .error(R.drawable.person)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)

        holder.itemView.setOnClickListener{
            listener.onClickedSimpsonItem(blog)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class SimpsonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val itemLayout: ConstraintLayout = itemView.findViewById(R.id.blog_layout)
    val textTitle: TextView = itemView.findViewById(R.id.text_title)
    val textDescription: TextView = itemView.findViewById(R.id.text_description)
    val image: AppCompatImageView = itemView.findViewById(R.id.image)

}