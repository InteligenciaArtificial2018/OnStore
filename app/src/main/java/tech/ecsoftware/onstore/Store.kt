package tech.ecsoftware.onstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Store : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        val pc = findViewById(R.id.imgComputadoras) as ImageView

        pc.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreComputers::class.java
            ))
        }

        val care = findViewById(R.id.imgCuidado) as ImageView

        care.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreCare::class.java
            ))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
