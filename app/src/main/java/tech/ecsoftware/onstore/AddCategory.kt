package tech.ecsoftware.onstore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_category.*
import tech.ecsoftware.onstore.data.StoreDB
import tech.ecsoftware.onstore.data.Categorias

class AddCategory : AppCompatActivity() {

    private var storeDatabase: StoreDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_products)

        storeDatabase = StoreDB.getInstance(this)

        // Validar si se nos envía el intent con el valor del título
        val nombreCategoria = intent.getStringExtra("nombre")
        val descripcionCategoria = intent.getStringExtra("descripcion")

        // Si no está definido o viene en blanco, el usuario presionó el FAB
        if (nombreCategoria == null || nombreCategoria == "") {
            btnAgregarTarea.setOnClickListener {
                val tarea = Categorias(etNombreCategoria.text.toString(), etDescripcionCategoria.text.toString())

                storeDatabase?.getCategoriasDBDao()?.saveCategorias(tarea)
                finish()
            }
        } else {
            val idIntent = intent.getIntExtra("idCategoria", 0)
            etNombreCategoria.setText(nombreCategoria)
            etDescripcionCategoria.setText(descripcionCategoria)
            btnAgregarTarea.setOnClickListener {
                val tarea = Categorias(etNombreCategoria.text.toString(), etDescripcionCategoria.text.toString())

                tarea.idCategoria = idIntent
                storeDatabase?.getCategoriasDBDao()?.updateCategorias(tarea)
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