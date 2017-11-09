package pl.com.example.dietplus.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*
import pl.com.example.dietplus.R

/**
 * Adapter listy odzyskiwalnej opisów składniku diety
 */
class RecyclerViewAdapter(
        private var items: ArrayList<Pair<String, String>>
                         ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.header.text = items[position].first
        holder.itemView.description_text.text = items[position].second
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val li = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return object : RecyclerView.ViewHolder(li){}
    }


}