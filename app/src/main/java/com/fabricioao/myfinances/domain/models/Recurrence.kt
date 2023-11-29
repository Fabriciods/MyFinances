package com.fabricioao.myfinances.domain.models

import java.util.Date

data class Recurrence(
    val name: String,
    val description: String? = null,
    val value: Double? = null,
    val isRecurrent: Boolean,
    val dueDate: Date,
    val type: RecurrenceType
)