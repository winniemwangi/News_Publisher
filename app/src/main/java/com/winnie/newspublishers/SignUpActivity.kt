package com.winnie.newspublishers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.winnie.newspublishers.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        castViews()
    }

    fun castViews(){


        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener { validateSignup() }

    }

    fun validateSignup(){
        var error = false
        var firstname = binding.etFirstName.text.toString()
        if (firstname.isBlank()){
            binding.tilFirstName.error  = ("FirstName required")
            error = true
        }

        var lastname= binding.etLastName.text.toString()
        if (lastname.isBlank()){
            binding.tilLastName.error  = ("SecondName required")
            error = true
        }

        var phoneNumber = binding.etPhoneNumber.text.toString()
        if (phoneNumber.isBlank()){
            binding.tilPhoneNumber.error  = ("PhoneNumber required")
            error = true
        }

        var email = binding.etEmailAddress.text.toString()
        if (email.isBlank()){
            binding.tilEmailAddress.error  = ("EmailAddress required")
            error = true
        }

        var password = binding.etPassword.text.toString()
        if (password.isBlank()){
            binding.tilPassword.error  = ("Password required")
            error = true
        }

        var confirm = binding.etConfirm.text.toString()
        if (confirm.isBlank()){
            binding.tilConfirm.error  = ("Confirm Password required")
            error = true
        }

        if (password!=confirm){
            error = true
            binding.tilConfirm.error = ("Doesn't match")

        }

        if (!error){
            var registerRequest = RegisterRequest(firstname, lastname, phoneNumber,email,password)
            makeRegisterRequest(registerRequest)
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    fun makeRegisterRequest(registerRequest: RegisterRequest){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message, Toast.LENGTH_LONG).show()
                    //navigate to login
                }
                else{
                    val error = response.errorBody()?.string()
                    Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }

        })


    }
}
