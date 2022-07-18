package com.example.eldarwallet.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.eldarwallet.R
import com.example.eldarwallet.databinding.ActivityQrBinding
import com.example.eldarwallet.ui.viewmodel.MenuViewModel
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

        //Preguntar si esta bien
        //Preguntar como cargar la imagen
        qrViewModel.getQRLiveData.observe(this, Observer {
            it->
            val name: String = binding.etInfo.text.toString()
            qrViewModel.callGetQRUseCase(name)
        })

    }
}
