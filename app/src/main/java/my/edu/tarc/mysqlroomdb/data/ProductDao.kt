package my.edu.tarc.mysqlroomdb.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(p : Product)
}