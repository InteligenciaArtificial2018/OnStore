package tech.ecsoftware.onstore.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Categorias")
class Categorias(
        @ColumnInfo(name  = "nombreCategoria")
        var nombreCategoria: String = "",
        @ColumnInfo(name = "descripción")
        var descripcionCategoria: String) {

        @PrimaryKey(autoGenerate = true)
        var idCategoria: Int = 0
}