package tech.ecsoftware.onstore.data

import android.arch.persistence.room.*

@Dao
interface ProductosDAO{

    /**
     * Inserta una nueva tupla en la tabla Productos.
     * @param productos la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveProductos(productos: Productos)


    /**
     * Actualiza una tupla en la tabla Productos.
     * @param productos el valor de la tupla a actualizar.
     */
    @Update
    fun updateProductos(productos: Productos)


    /**
     * Remueve una tupla de la tabla Productos.
     * @param productos el valor de la tupla a remover.
     */
    @Delete
    fun deleteProductos(productos: Productos)
}