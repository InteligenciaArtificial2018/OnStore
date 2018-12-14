package tech.ecsoftware.onstore.data

import android.arch.persistence.room.*

@Dao
interface CategoriasDAO{
    /**
     * Retorna todos las tuplas de Todo en orden ascendente.
     */
    @Query("SELECT * FROM Categorias ORDER BY idCategoria ASC")
    fun getCategoryList(): List<Categorias>

    /**
     * Retorna una tupla desde la tabla todo
     * @param id el valor de la llave primaria a retornar.
     */
    @Query("SELECT * FROM Categorias WHERE idCategoria = :id")
    fun getCategoryItem(id: Int): Categorias

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