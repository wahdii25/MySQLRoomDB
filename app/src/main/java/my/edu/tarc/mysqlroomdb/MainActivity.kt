package my.edu.tarc.mysqlroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import my.edu.tarc.mysqlroomdb.data.Product
import my.edu.tarc.mysqlroomdb.data.ProductDB
import my.edu.tarc.mysqlroomdb.data.ProductDao

class MainActivity : AppCompatActivity() {

    lateinit var dao : ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInsert : Button = findViewById(R.id.btnInsert)

        dao = ProductDB.getInstance(application).productDao

        btnInsert.setOnClickListener(){
            val p = Product(0,"Apple",1.50)

            CoroutineScope(IO).launch {
                dao.insertProduct(p)
            }

        }

    }
}