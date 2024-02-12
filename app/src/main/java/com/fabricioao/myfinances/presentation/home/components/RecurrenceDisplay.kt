package com.fabricioao.myfinances.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fabricioao.myfinances.domain.models.Recurrence
import com.fabricioao.myfinances.domain.models.RecurrenceType
import com.fabricioao.myfinances.presentation.home.components.Constants.DEFAULT_BALANCE
import com.fabricioao.myfinances.presentation.ui.theme.Black
import com.fabricioao.myfinances.presentation.ui.theme.WhiteBox
import com.fabricioao.myfinances.utils.toBrazilianFormat
import com.fabricioao.myfinances.utils.toCurrency

@Composable
fun RecurrenceDisplay(
    recurrence: Recurrence,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        color = WhiteBox
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = recurrence.name,
                color = Black
            )
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = 4.dp)
            ) {
                Text(
                    text = recurrence.dueDate.toBrazilianFormat(),
                    color = Black
                )
                Text(
                    text = addSymbolToCurrency(
                        recurrence.value ?: DEFAULT_BALANCE,
                        recurrence.type
                    ),
                    color = if (recurrence.type == RecurrenceType.Expense)
                        Color.Red
                    else
                        Color.Green
                )
            }
        }

    }
}

private fun addSymbolToCurrency(value: Double, type: RecurrenceType): String {
    return if (type == RecurrenceType.Active)
        "+ ${value.toCurrency()}"
    else
        "- ${value.toCurrency()}"
}

private object Constants {
    const val DEFAULT_BALANCE = 0.0
}

