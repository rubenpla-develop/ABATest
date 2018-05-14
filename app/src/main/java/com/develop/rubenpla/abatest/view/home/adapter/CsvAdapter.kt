package rubenpla.develop.privtmdbendlesslist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.develop.rubenpla.abatest.R
import com.develop.rubenpla.abatest.model.CsvItemModel
import kotlinx.android.synthetic.main.item_list.view.*

class CsvAdapter (private val list : MutableList<CsvItemModel>,
                        private val listener : CsvItemModel)
    : RecyclerView.Adapter<CsvAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list.get(position)
        holder.title.text = item.title
        holder.description.text = item.description
        //TODO picasso imageloading
        // holder.image
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