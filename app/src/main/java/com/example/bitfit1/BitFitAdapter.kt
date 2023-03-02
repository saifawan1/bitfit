package com.example.bitfit1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val ITEM_EXTRA = "ITEM_EXTRA"
private const val TAG = "BitFitAdapter"

class BitFitAdapter(private val items: List<DisplayBitFit>) : RecyclerView.Adapter<BitFitAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val namesTextView: TextView
        val pricesTextView: TextView

        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            namesTextView = itemView.findViewById(R.id.foodTv)
            pricesTextView = itemView.findViewById(R.id.calNumTv)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_bitfit, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items[position]
        // Set item views based on views and data model
        holder.namesTextView.text = item.foodName
        holder.pricesTextView.text = item.calories
    }
    override fun getItemCount(): Int {
        return items.size
    }
}