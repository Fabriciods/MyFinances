package com.fabricioao.myfinances.domain.models

data class MonthBalance(
    val name: String,
    val totalBalance: Double,
    val expenses: Double,
    val positiveAmount: Double
)
