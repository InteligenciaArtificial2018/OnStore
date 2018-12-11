package tech.ecsoftware.onstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.pm.PackageManager

class RedesSocial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        val fb = findViewById(R.id.imgFB) as ImageView

        fb.setOnClickListener(){
                    val fb  = getPackageManager().getLaunchIntentForPackage("com.facebook.katana")
                    startActivity(fb)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
