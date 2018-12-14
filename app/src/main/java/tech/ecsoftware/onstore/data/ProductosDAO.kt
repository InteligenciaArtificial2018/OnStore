package tech.ecsoftware.onstore.data

import android.arch.persistence.room.*

@Dao
interface ProductosDAO{
    /**
     * Retorna todos las tuplas de Todo en orden ascendente.
     */
    @Query("SELECT * FROM productos ORDER BY idProducto ASC")
    fun getProductList(): List<Productos>

    /**
     * Retorna una tupla desde la tabla todo
     * @param id el valor de la llave primaria a retornar.
     */
    @Query("SELECT * FROM productos WHERE idProducto = :id")
    fun getProductItem(id: Int): Productos

    /**
     * Inserta una nueva tupla en la tabla todo.
     * @param todo la tupla a insertar en la tabla.
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