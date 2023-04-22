package com.anmp.a160420121_uts_anmp.model

data class Kos(
    val idkos:String? = "",
    val nama:String? = "",
    val alamat:String? = "",
    val tipekos:String? = "",
    val url:String? = "",
    val wifi:String? = "",
    val kamar:ArrayList<Kamar>? = arrayListOf(),
    val deskripsi:String? = ""
)
