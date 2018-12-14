package tech.ecsoftware.onstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_care.*
import tech.ecsoftware.onstore.data.Productos
import tech.ecsoftware.onstore.data.StoreDB

class StoreKids : AppCompatActivity(), CareAdapter.OnProductItemClickListener {

    private var storeDatabase: StoreDB? = null
    private var careAdapter: CareAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care)

        storeDatabase = StoreDB.getInstance(this)
        careAdapter = CareAdapter(storeDatabase?.getProductosDBDao()?.getProductList())
        careAdapter?.setProductItemClickListener(this)

        // Llamar la activity de agregar tarea mediante el floating action button
        fabAddProduct.setOnClickListener {
            startActivity(Intent(this, AddProducts::class.java))
        }
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onResume() {
        super.onResume()
        careAdapter?.productList = storeDatabase?.getProductosDBDao()?.getProductList()
        rvProduct.adapter = careAdapter
        rvProduct.layoutManager = LinearLayoutManager(this)
        rvProduct.hasFixedSize()
    }

    /**
     * Sobreescribimos la funcionalidad de click desde la herencia de la interfaz
     * del TodoAdapter. Enviamos la información mediante un intent con parámetros
     * hacia el layout correspondiente.
     */

    override fun onProductItemClickListener(product: Productos) {
        val intent = Intent(this, AddProducts::class.java)
        intent.putExtra("idProducto", product.idProducto)
        intent.putExtra("nombre", product.nombre)
        intent.putExtra("categoria", product.categoria)
        intent.putExtra("cantidad", product.cantidad)
        intent.putExtra("descripcion", product.descripcion)
        intent.putExtra("precio", product.precio)

        startActivity(intent)
    }

    override fun onProductItemLongClickListener(product: Productos) {
        // Inicializar una nueva instancia de AlertDialog
        val builder = AlertDialog.Builder(this)

        // Colocar el titulo del dialogo
        builder.setTitle(R.string.tituloDialogoLongClick)

        // Mensaje a desplegar en el dialogo
        builder.setMessage(R.string.mensajeDialogoLongClick)

        // Los dialogos pueden tener hasta 3 botones, uno positivo (SI), uno negativo (NO)
        // y un boton neutro (CANCEL) los cuales utilizaremos para Modificar, Eliminar y Cancelar
        builder.setPositiveButton(R.string.modificar) {dialog, wich ->
            // Realizar el llamado a la activity de agregar enviando los valores mediante el intent
            val intent = Intent(this, AddProducts::class.java)
            intent.putExtra("idProducto", product.idProducto)
            intent.putExtra("nombre", product.nombre)
            intent.putExtra("categoria", product.categoria)
            intent.putExtra("cantidad", product.cantidad)
            intent.putExtra("descripcion", product.descripcion)
            intent.putExtra("precio", product.precio)

            startActivity(intent)
        }

        builder.setNegativeButton(R.string.eliminar) {dialog, which ->
            storeDatabase?.getProductosDBDao()?.deleteProductos(product)
            onResume()
            Toast.makeText(this, R.string.mensajetareaEliminada, Toast.LENGTH_SHORT).show()
        }

        builder.setNeutralButton(R.string.cancelar) {dialog, which ->
            Toast.makeText(this,R.string.mensajeCancelarDialogoLongClick, Toast.LENGTH_SHORT).show()
        }

        // Crear el dialogo de alerta con todos los parámetros establecidos
        val dialogo: AlertDialog = builder.create()

        // Mostrar el dialogo
        dialogo.show()
    }
}
