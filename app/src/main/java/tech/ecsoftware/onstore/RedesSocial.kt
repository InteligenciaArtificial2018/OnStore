package tech.ecsoftware.onstore

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.pm.PackageManager
import android.widget.Toast

class RedesSocial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)

        // Variables para ejecutar apps externas desde click en image view
        val fb = findViewById(R.id.imgFB) as ImageView
        val ig = findViewById(R.id.imgIG) as ImageView
        val tw = findViewById(R.id.imgTW) as ImageView

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        // Verificar App facebook
        if(verificarApp("com.facebook.katana", getApplicationContext())){

            fb.setOnClickListener(){
                val fb  = getPackageManager().getLaunchIntentForPackage("com.facebook.katana")
                startActivity(fb)
            }

        }
        else{
            fb.setOnClickListener(){
                Toast.makeText(this, "La app no está instalada!", Toast.LENGTH_SHORT).show()
            }
        }

        // Verificar App instagram
        if(verificarApp("com.instagram.android", getApplicationContext())){

            ig.setOnClickListener(){
                val ig  = getPackageManager().getLaunchIntentForPackage("com.instagram.android")
                startActivity(ig)
            }

        }
        else{
            ig.setOnClickListener(){
                Toast.makeText(this, "La app no está instalada!", Toast.LENGTH_SHORT).show()
            }
        }


        // Verificar App twitter
        if(verificarApp("com.twitter.android", getApplicationContext())){

            tw.setOnClickListener(){
                val tw  = getPackageManager().getLaunchIntentForPackage("com.twitter.android")
                startActivity(tw)
            }

        }
        else if(!verificarApp("com.twitter.android", getApplicationContext())){
            tw.setOnClickListener(){
                Toast.makeText(this, "La app no está instalada!", Toast.LENGTH_SHORT).show()
            }
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
