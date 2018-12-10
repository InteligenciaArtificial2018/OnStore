package tech.ecsoftware.onstore.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Productos::class, Categorias::class, RegistroCompra::class, Usuarios::class], version = 1, exportSchema = false)
abstract class StoreDB: RoomDatabase() {
    /**
     * Este es un método abstracto que retorna el DAO para la base de datos.
     */
    abstract fun getStoreDBDao(): StoreDBDao

    /**
     * Un patrón de diseño Singleton es utilizado para asegurarnos que
     * solamente se cree una instancia de la base de datos.
     */
    companion object {
        val databaseName = "storeDB"
        var storedb: StoreDB? = null

        fun getInstance(context: Context): StoreDB? {
            if (StoreDB == null) {
                storedb = Room.databaseBuilder(
                        context,
                        StoreDB::class.java,
                        StoreDB.databaseName
                )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return storedb
        }
    }
}
