package com.develop.rubenpla.abatest.view.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.develop.rubenpla.abatest.R
import com.develop.rubenpla.abatest.model.CsvItemModel
import com.develop.rubenpla.abatest.util.CvsAdapterController
import com.develop.rubenpla.abatest.util.image.ScaleToFitWidthHeightTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class CsvAdapter (private val list: MutableList<CsvItemModel>,
                  private val listener: (CsvItemModel) -> Unit)
    : RecyclerView.Adapter<CsvAdapter.ItemViewHolder>() {

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        return ItemViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.title
        holder.description.text = item.description

        Picasso.with(context)
                .load(CvsAdapterController.provideValidImageResource(list[position].imageUrl))
                .resizeDimen(R.dimen.image_thumb_width, R.dimen.image_thumb_height)
                .centerCrop()
                .onlyScaleDown()
                .priority(Picasso.Priority.HIGH)
                .transform(ScaleToFitWidthHeightTransform(context.resources
                        .getDimensionPixelSize(R.dimen.image_thumb_width), false))
                .error(R.mipmap.ic_launcher_round)
                .into(holder.image)

        holder.itemView.setOnClickListener {
            listener(item)
        }
    }

    /**
     *    HELPERS
     **/

    fun getItem(position: Int): CsvItemModel? {
        return list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(item : CsvItemModel) {
        list.add(item)
        notifyItemInserted(list.size -1)
    }

    fun addAll(movies: ArrayList<CsvItemModel>) {
        list.addAll(movies)
        notifyItemRangeChanged( movies.size,list.size -1)
    }

    fun remove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(list.size)
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    /**
     *    HOLDERS
     **/
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.item_list_title!!
        val description = itemView.item_list_description!!
        val image = itemView.item_list_card_view_image_view!!
    }
}