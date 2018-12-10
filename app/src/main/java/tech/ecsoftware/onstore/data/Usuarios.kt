package tech.ecsoftware.onstore.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Usuarios")
class Usuarios(
        @ColumnInfo(name  = "Nombre")
        var nombreCliente: String = "",
        @ColumnInfo(name = "Apellido")
        var apellidoCliente: String,
        @ColumnInfo(name = "Correo")
        var correoCliente: String,
        @ColumnInfo(name = "Tarjeta de crédito")
        var tarjetaCliente: String) {

        @PrimaryKey(autoGenerate = true)
        var idCliente: Int = 0
}