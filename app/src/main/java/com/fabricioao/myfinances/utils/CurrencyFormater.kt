package com.fabricioao.myfinances.utils

import java.text.NumberFormat
import java.util.Locale


fun Double.toCurrency():String{
    val format =  NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return format.format(this)
}