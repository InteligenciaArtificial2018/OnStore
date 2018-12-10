package tech.ecsoftware.onstore.data

import android.arch.persistence.room.*

@Dao
interface StoreDBDao {

    /**
     * Inserta una nueva tupla en la tabla Categorias, Productos, Usuarios y RegistroCompra.
     * @param categorias @param productos @param usuarios @param registroCompra la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveCategorias(categorias: Categorias)
    fun saveProductos(productos:Productos)
    fun saveUsuarios(usuarios:Usuarios)
    fun saveRegistroActividad(registroCompra: RegistroCompra)

    /**
     * Actualiza una tupla en la tabla Catedraticos, Clases y RegistroActividad.
     * @param categorias @param productos @param usuarios @param registroCompra el valor de la tupla a actualizar.
     */
    @Update
    fun updateCategorias(categorias: Categorias)
    fun updateProductos(productos: Productos)
    fun updateUsuarios(usuarios:Usuarios)
    fun updateRegistroCompra(registroCompra: RegistroCompra)

    /**
     * Remueve una tupla de la tabla Catedraticos, Clases y RegistroActividad.
     * @param categorias @param productos @param usuarios @param registroCompra el valor de la tupla a remover.
     */
    @Delete
    fun deleteCategorias(categorias: Categorias)
    fun deleteProductos(productos: Productos)
    fun deleteUsuarios(usuarios:Usuarios)
    fun deleteRegistroCompra(registroCompra: RegistroCompra)


}