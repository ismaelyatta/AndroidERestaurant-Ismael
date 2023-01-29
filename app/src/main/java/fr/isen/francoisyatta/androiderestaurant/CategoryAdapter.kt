package fr.isen.francoisyatta.androiderestaurant

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.francoisyatta.androiderestaurant.model.Items

class CategoryAdapter(private var dishes: ArrayList<Items>, private val OnChildClickListener: () -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellName = view.findViewById<TextView>(R.id.cellName)
        val cellPicture = view.findViewById<ImageView>(R.id.cellPicture)
        val cellPrice = view.findViewById<TextView>(R.id.price)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_cell, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dish = dishes[position]
        holder.cellName.text = dish.nameFr
        holder.cellPrice.text = "${dish.prices[0].price} $"

        val firstImage = dish.images[0]
        if (firstImage.isNotEmpty()){
            Picasso.get().load(firstImage).into(holder.cellPicture)
        }
        OnChildClickListener
        holder.cellName.text

    }


    override fun getItemCount() = dishes.size


    fun refreshList(dishesFromAPI: ArrayList<Items>) {
        dishes = dishesFromAPI
        notifyDataSetChanged()

    }

}
