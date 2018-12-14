package tech.ecsoftware.onstore

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_care.*
import kotlinx.android.synthetic.main.activity_main.*
import tech.ecsoftware.onstore.data.StoreDB
import tech.ecsoftware.onstore.data.Productos

class MainActivity : AppCompatActivity(){

    private val PICK_IMAGE = 100
    var imageUri: Uri? = null
    var foto_gallery: ImageView? = null


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*foto_gallery = findViewById<View>(R.id.foto_gallery)

        foto_gallery!!.setOnClickListener(object : View.OnClickListener() {
            fun onClick(v: View) {
                openGallery()
            }
        })*/

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

    fun openGallery(){
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData()
            foto_gallery?.setImageURI(imageUri)
        }
    }


}

