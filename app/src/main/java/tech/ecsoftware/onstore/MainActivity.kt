package tech.ecsoftware.onstore

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv = findViewById(R.id.imgLogo) as ImageView

        iv.setOnClickListener(){
            startActivity(Intent(
                    this@MainActivity,
                    AcercaDe::class.java
            ))
        }

        btnInfo.setOnClickListener {
            val info = Intent(this, AcercaDe::class.java)
            startActivity(info)
        }

        btnBuy.setOnClickListener {
            val buy = Intent(this, Store::class.java)
            startActivity(buy)
        }

        btnSocial.setOnClickListener {
            val social = Intent(this, RedesSocial::class.java)
            startActivity(social)
        }

        btnContact.setOnClickListener {
            val contact = Intent(this, Contact::class.java)
            startActivity(contact)
        }

    }

}
