package tech.ecsoftware.onstore

import android.content.Context
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

        val ig = findViewById(R.id.imgIG) as ImageView

        ig.setOnClickListener(){
            val ig  = getPackageManager().getLaunchIntentForPackage("com.instagram.android")
            startActivity(ig)
        }

        val tw = findViewById(R.id.imgTW) as ImageView

        tw.setOnClickListener(){
            val tw  = getPackageManager().getLaunchIntentForPackage("com.twitter.android")
            startActivity(tw)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun verificarApp(nombreApp: String, context: Context): Boolean {

        val paquete = context.getPackageManager()
        try {
            paquete.getPackageInfo(nombreApp, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }

    }
}
