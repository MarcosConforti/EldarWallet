package com.example.eldarwallet.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.eldarwallet.R
import com.example.eldarwallet.databinding.ActivityLoginBinding
import com.example.eldarwallet.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
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
            } else {
                showError()
            }
        })

    }

    private fun initDialog() {
        // set
        val dialogView = layoutInflater.inflate(R.layout.progress_bar, null)
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

    private fun showError() {
        Toast.makeText(this, getText(R.string.loginError), Toast.LENGTH_SHORT).show()
    }
}