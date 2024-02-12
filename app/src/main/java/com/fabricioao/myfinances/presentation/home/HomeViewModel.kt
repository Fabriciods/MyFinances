package com.fabricioao.myfinances.presentation.home

import androidx.lifecycle.ViewModel
import com.fabricioao.myfinances.domain.models.MonthBalance
import com.fabricioao.myfinances.domain.models.Recurrence
import com.fabricioao.myfinances.domain.models.RecurrenceType
import com.fabricioao.myfinances.domain.models.StatusModel
import com.fabricioao.myfinances.domain.models.UserModel
import java.util.Calendar

class HomeViewModel : ViewModel() {

    var userModel = UserModel("Fabricio")
    var balance = 43.4
    var mountBalance = MonthBalance(
        "Janeiro",
        totalBalance = 12.3,
        expenses = 12.5,
        positiveAmount = 30.4,
        status = StatusModel.POSITIVE
    )
    var recurrenceList = listOf(Recurrence(
        "Mock",
        description = "Inválido",
        value = 45.3,
        isRecurrent = true,
        dueDate = Calendar.getInstance().time,
        type = RecurrenceType.Active
    ),
        Recurrence(
            "Força",
            description = "Inválido",
            value = 45.3,
            isRecurrent = true,
            dueDate = Calendar.getInstance().time,
            type = RecurrenceType.Active
        ),
        Recurrence(
            "Força",
            description = "Inválido",
            value = 45.3,
            isRecurrent = true,
            dueDate = Calendar.getInstance().time,
            type = RecurrenceType.Active
        )
    )
}