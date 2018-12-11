package tech.ecsoftware.onstore.data

import android.arch.persistence.room.*

@Dao
interface UsuariosDAO{

    /**
     * Inserta una nueva tupla en la tabla Usuarios.
     * @param usuarios la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveUsuarios(usuarios: Usuarios)


    /**
     * Actualiza una tupla en la tabla Usuarios.
     * @param usuarios el valor de la tupla a actualizar.
     */
    @Update
    fun updateUsuarios(usuarios: Usuarios)


    /**
     * Remueve una tupla de la tabla Usuarios.
     * @param usuarios el valor de la tupla a remover.
     */
    @Delete
    fun deleteUsuarios(usuarios: Usuarios)
}