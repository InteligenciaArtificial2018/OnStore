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

        val cars = findViewById(R.id.imgAutomotriz) as ImageView

        cars.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreCars::class.java
            ))
        }

        val electronic = findViewById(R.id.imgElectronica) as ImageView

        electronic.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreElectronic::class.java
            ))
        }

        val games = findViewById(R.id.imgVideojuegos) as ImageView

        games.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreGames::class.java
            ))
        }

        val health = findViewById(R.id.imgSalud) as ImageView

        health.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreHealth::class.java
            ))
        }

        val kids = findViewById(R.id.imgBebes) as ImageView

        kids.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreKids::class.java
            ))
        }

        val sports = findViewById(R.id.imgDeportes) as ImageView

        sports.setOnClickListener(){
            startActivity(Intent(
                    this@Store,
                    StoreSports::class.java
            ))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
