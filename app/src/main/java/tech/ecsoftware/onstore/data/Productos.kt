package tech.ecsoftware.onstore.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Productos")
class Productos(
        @ColumnInfo(name = "Nombre del producto")
        var nombreProducto: String = "",
        @ColumnInfo(name = "Categoria")
        var idCategoria: String = "",
        @ColumnInfo(name = "Cantidad en inventario")
        var cantidadProducto: String = "",
        @ColumnInfo(name = "Descripción")
        var descripcionProducto: String = "",
        @ColumnInfo(name = "Precio")
        var precioProdcuto: Double = 0.00) {

        @PrimaryKey(autoGenerate = false)
        var idProducto: String = ""
}