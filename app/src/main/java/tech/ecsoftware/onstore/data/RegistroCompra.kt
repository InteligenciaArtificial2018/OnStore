package tech.ecsoftware.onstore.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Registro de compras")
class RegistroCompra(
        @ColumnInfo(name = "Producto")
        var idProducto: String = "",
        @ColumnInfo(name = "Cliente")
        var idCliente: String = "",
        @ColumnInfo(name = "Cantidad")
        var cantidadProductoComprada: String = "",
        @ColumnInfo(name = "Total pagado")
        var totalPagado: Double = 0.00) {

    @PrimaryKey(autoGenerate = false)
    var idCompra: String = ""
}