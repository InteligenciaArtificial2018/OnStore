package tech.ecsoftware.onstore.data

import android.arch.persistence.room.*

@Dao
interface CategoriasDAO{

    /**
     * Inserta una nueva tupla en la tabla Categorias.
     * @param categorias la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveCategorias(categorias: Categorias)


    /**
     * Actualiza una tupla en la tabla Categorias.
     * @param categorias el valor de la tupla a actualizar.
     */
    @Update
    fun updateCategorias(categorias: Categorias)


    /**
     * Remueve una tupla de la tabla Categorias.
     * @param categorias el valor de la tupla a remover.
     */
    @Delete
    fun deleteCategorias(categorias: Categorias)
}