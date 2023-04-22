package com.anmp.a160420121_uts_anmp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anmp.a160420121_uts_anmp.model.Kamar
import com.anmp.a160420121_uts_anmp.model.Kos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class KamarDetailModel (application: Application): AndroidViewModel(application) {
    var kamarList = MutableLiveData<Kamar>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(idkamar:String,idkos:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://raw.githubusercontent.com/theboss99915/dataset/main/koskita.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Kos>>() { }.type
                val result = Gson().fromJson<List<Kos>>(it, sType)
                result.forEach{
                    if (it.idkos.equals(idkos)){
                        it.kamar?.forEach {
                            if(it.id.equals(idkamar)){
                                kamarList.value = it
                            }
                        }
                    }
                }
                Log.d("errorshowdetailkamar", kamarList.value.toString())

            },
            {
                Log.d("showdetailkamar", kamarList.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}