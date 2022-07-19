package com.example.eldarwallet.ui.activities

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.eldarwallet.databinding.ActivityQrBinding
import com.example.eldarwallet.ui.viewmodel.QrViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QrActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQrBinding
    private val qrViewModel: QrViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrBinding.inflate(layoutInflater)
        setContentView(binding.root)


        qrViewModel.getQRLiveData.observe(this, Observer { bitmap ->
            bitmap?.let { binding.ivQr.setImageBitmap(bitmap); }

        })
        binding.btnMostrarQr.setOnClickListener {
            val name: String = binding.etInfo.text.toString()

            if(name.isNotEmpty()){
                qrViewModel.callGetQRUseCase(name)
            }else{
                Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            }
        }


    }
}
