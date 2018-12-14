package tech.ecsoftware.onstore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_products.*
import tech.ecsoftware.onstore.data.StoreDB
import tech.ecsoftware.onstore.data.Productos

class AddProducts : AppCompatActivity() {

    private var storeDatabase: StoreDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_products)

        storeDatabase = StoreDB.getInstance(this)

        // Validar si se nos envía el intent con el valor del título
        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("descripcion")
        val cantidad = intent.getStringExtra("cantidad")
        val precio = intent.getStringExtra("precio")
        val categoria = intent.getStringExtra("categoria")

        // Si no está definido o viene en blanco, el usuario presionó el FAB
        if (nombre == null || nombre == "") {
            btnAgregarProducto.setOnClickListener {
                val tarea = Productos(etNombre.text.toString(), etCategoria.text.toString(), etCantidad.text.toString(),
                        etDescripcion.text.toString(), etPrecio.text.toString())

                storeDatabase?.getProductosDBDao()?.saveProductos(tarea)
                finish()
            }
        } else {
            val idIntent = intent.getIntExtra("idProducto", 0)
            etNombre.setText(nombre)
            etCategoria.setText(categoria)
            etCantidad.setText(cantidad)
            etDescripcion.setText(descripcion)
            etPrecio.setText(precio)
            btnAgregarProducto.setOnClickListener {
                val tarea = Productos(etNombre.text.toString(), etCategoria.text.toString(), etCantidad.text.toString(),
                        etDescripcion.text.toString(), etPrecio.text.toString())
                tarea.idProducto = idIntent
                storeDatabase?.getProductosDBDao()?.updateProductos(tarea)
                finish()
            }
        }
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}