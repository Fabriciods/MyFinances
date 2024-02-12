package com.fabricioao.myfinances.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toBrazilianFormat(): String{
    val format = SimpleDateFormat("dd/MM/yyyy", Locale("pt","BR"))
    return format.format(this)
}