package com.fabricioao.myfinances.presentation.home.components

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabricioao.myfinances.domain.models.Recurrence
import com.fabricioao.myfinances.domain.models.RecurrenceType
import com.fabricioao.myfinances.presentation.ui.theme.MyFinancesTheme
import com.fabricioao.myfinances.presentation.ui.theme.PurpleGrey40
import com.fabricioao.myfinances.presentation.ui.theme.White
import java.time.Instant
import java.util.Calendar
import java.util.Date

@Composable
fun RecurrenceDisplay(
    recurrence: Recurrence,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        color = PurpleGrey40
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
                color = White
            )
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = recurrence.dueDate.toString(),
                    color = White
                )
                Text(
                    text = recurrence.value.toString(),
                    color = if (recurrence.type == RecurrenceType.Expense)
                        Color.Red
                        else
                        Color.Green
                )
            }
        }

    }
}

@Composable
@Preview
fun PreviewTes() {
    MyFinancesTheme {
        RecurrenceDisplay(
            recurrence = Recurrence(
                name = "Força",
                description = null,
                value = 34.4,
                dueDate = Calendar.getInstance().time,
                isRecurrent = true,
                type = RecurrenceType.Active
            )
        )
    }
}