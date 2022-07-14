package com.example.eldarwallet.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.eldarwallet.MenuActivity
import com.example.eldarwallet.R
import com.example.eldarwallet.databinding.ActivityMainBinding
import com.example.eldarwallet.ui.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var  dialog:AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDialog()

        binding.button.setOnClickListener {
            val user = binding.etUser.text.toString()
            val pass = binding.etPass.text.toString()
            userViewModel.callUserUseCase(user, pass)
            dialog.show()
        }

        userViewModel.userLiveData.observe(this, Observer { isUserValid ->
            dialog.dismiss()
            if (isUserValid) {
              gotoMenu()
            }else{
                showError()
            }
        })


    }

    fun initDialog(){
        // set
        val dialogView = layoutInflater.inflate(R.layout.progress_bar,null)
        //set Dialog
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        builder.setCancelable(false)
        dialog = builder.create()
    }

    private fun gotoMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun showError(){
        Toast.makeText(this,getText(R.string.loginError),Toast.LENGTH_SHORT).show()
    }
}