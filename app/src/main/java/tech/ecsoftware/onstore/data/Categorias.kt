package tech.ecsoftware.onstore.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Productos")
class Categorias(
        @ColumnInfo(name  = "Nombre del categoria")
        var nombreCategoria: String = "",
        @ColumnInfo(name = "Descripción")
        var descripcionCategoria: String) {

        @PrimaryKey(autoGenerate = false)
        var idCategoria: String = ""
}