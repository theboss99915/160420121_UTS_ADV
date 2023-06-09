package com.anmp.a160420121_uts_anmp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anmp.a160420121_uts_anmp.model.Kos
import com.anmp.a160420121_uts_anmp.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LoginViewModel (application: Application): AndroidViewModel(application){
    var userLog = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(username:String,password:String){
        userLog.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://raw.githubusercontent.com/theboss99915/dataset/main/users.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<User>>() { }.type
                val result = Gson().fromJson<List<User>>(it, sType)
                result.forEach{
                    if (it.username.equals(username) && it.password.equals(password)){
                        userLog.value = true
                    }
                }
                Log.d("showuser", userLog.value.toString())

            },
            {
                userLog.value = false
                Log.d("showuser", userLog.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}