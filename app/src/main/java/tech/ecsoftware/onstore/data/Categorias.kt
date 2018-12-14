package tech.ecsoftware.onstore.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Categorias")
class Categorias(
        @ColumnInfo(name  = "Nombre de la categoria")
        var nombreCategoria: String = "",
        @ColumnInfo(name = "Descripción")
        var descripcionCategoria: String) {

        @PrimaryKey(autoGenerate = true)
        var idCategoria: Int = 0
}