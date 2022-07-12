package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class ItemAdapter(private val context:Context,
                  private val dataset:List<Affirmation>
                  ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView:TextView = view.findViewById(R.id.item_title)
        val imageView:ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace content of the views  inside a list item
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // get the data from list at the given  position
        val item = dataset[position]
        //update the views in the list item with the new information.
        holder.textView.text = context.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * return size of your dataset
     */
    override fun getItemCount() = dataset.size
}