package tech.ecsoftware.onstore.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "productos")
class Productos(
        @ColumnInfo(name = "nombre")
        var nombre: String = "",
        @ColumnInfo(name = "categoria")
        var categoria: String = "",
        @ColumnInfo(name = "cantidad")
        var cantidad: String = "",
        @ColumnInfo(name = "descripción")
        var descripcion: String = "",
        @ColumnInfo(name = "precio")
        var precio: String = "") {

        @PrimaryKey(autoGenerate = true)
        var idProducto: Int = 0
}