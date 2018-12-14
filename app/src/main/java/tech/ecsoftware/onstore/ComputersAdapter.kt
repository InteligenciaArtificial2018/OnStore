package tech.ecsoftware.onstore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import tech.ecsoftware.onstore.data.Productos

class ComputersAdapter(var productList: List<Productos>? = ArrayList<Productos>()): RecyclerView.Adapter<ComputersAdapter.ViewHolder>() {
    private var onProductItemClickListener: OnProductItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ComputersAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_productos, parent, false)

        return ViewHolder(vista, productList!!)
    }

    override fun getItemCount(): Int {
        return productList?.count()!!
    }

    override fun onBindViewHolder(holder: ComputersAdapter.ViewHolder, position: Int) {
        // Obtener la posición del item clickeado
        holder.vista.setOnClickListener{
            onProductItemClickListener?.onProductItemClickListener(productList?.get(position)!!)
        }
        holder.vista.setOnLongClickListener{
            onProductItemClickListener?.onProductItemLongClickListener(productList?.get(position)!!)
            true
        }
        holder.onBindViews(position)
    }

    class ViewHolder(val vista: View, val productList: List<Productos>): RecyclerView.ViewHolder(vista) {
        fun onBindViews(position: Int) {
            vista.findViewById<TextView>(R.id.tvProducto).text = productList.get(position).nombre
            vista.findViewById<ImageView>(R.id.imgProducto).setImageResource(getImage())

        }

        private fun getImage() = R.drawable.care1
    }

    /**
     * Utilizamos un método en lugar de asignar la funcionalidad vía el constructor
     * de la clase principal para mayor comodidad al momento de sobreescribir la funcionalidad.
     */
    fun setProductItemClickListener(onProductItemClickListener: OnProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener
    }

    /**
     * Definimos la interface que permite extender métodos que el RecyclerView no posee
     */
    interface OnProductItemClickListener {
        fun onProductItemClickListener(productos: Productos)
        fun onProductItemLongClickListener(productos: Productos)
    }
}