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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class KosDetailModel (application: Application): AndroidViewModel(application){
    var kosList = MutableLiveData<Kos>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(id:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://raw.githubusercontent.com/theboss99915/dataset/main/koskita.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Kos>>() { }.type
                val result = Gson().fromJson<List<Kos>>(it, sType)
                result.forEach{
                    if (it.idkos.equals(id)){
                        kosList.value = it
                    }
                }
                Log.d("errorshowdetail", kosList.value.toString())

            },
            {
                Log.d("showdetail", kosList.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}