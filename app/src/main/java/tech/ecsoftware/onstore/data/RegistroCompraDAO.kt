package tech.ecsoftware.onstore.data

import android.arch.persistence.room.*

@Dao
interface RegistroCompraDAO{

    /**
     * Inserta una nueva tupla en la tabla RegistroCompra.
     * @param registros la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveRegistros(registros: RegistroCompra)


    /**
     * Actualiza una tupla en la tabla RegistroCompra.
     * @param registros el valor de la tupla a actualizar.
     */
    @Update
    fun updateRegistros(registros: RegistroCompra)


    /**
     * Remueve una tupla de la tabla RegistroCompra.
     * @param registros el valor de la tupla a remover.
     */
    @Delete
    fun deleteRegistros(registros: RegistroCompra)
}