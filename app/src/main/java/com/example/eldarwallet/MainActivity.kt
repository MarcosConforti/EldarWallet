package com.example.eldarwallet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eldarwallet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //private ProgressBar progressBar
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //progressBar.setVisibility(View.GONE)

       /* fun Click(view: View?) {
            if (binding.etUser.getText() == "usuario" && binding.etPass.getText() == "123"
            ) {
                Toast.makeText(this, "Anda Bien", Toast.LENGTH_SHORT).show()
            }else{
              Toast.makeText(this, "Anda Mal", Toast.LENGTH_SHORT).show()
            }
        }*/
    }
}