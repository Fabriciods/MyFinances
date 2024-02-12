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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabricioao.myfinances.domain.models.MonthBalance
import com.fabricioao.myfinances.domain.models.StatusModel
import com.fabricioao.myfinances.presentation.ui.theme.MyFinancesTheme
import com.fabricioao.myfinances.presentation.ui.theme.WhiteBox
import com.fabricioao.myfinances.utils.toCurrency

@Composable
fun MonthBalanceComposable(
    mountBalance: MonthBalance,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        color = WhiteBox
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = mountBalance.totalBalance.toCurrency(),
                color = if (mountBalance.status == StatusModel.POSITIVE) Color.Green else Color.Red
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(text = "Entradas")
                    Text(text = mountBalance.positiveAmount.toCurrency(),
                        color = Color.Green)
                }
                Column{
                    Text(text = "Saidas")
                    Text(text = mountBalance.expenses.toCurrency(), color = Color.Red)
                }
            }
        }
    }
}

@Preview()
@Composable
fun BalancePreview () {
    MyFinancesTheme {
        MonthBalanceComposable(mountBalance = MonthBalance(
            name = "Janeiro",
            totalBalance = 500.10,
            expenses = 120.0,
            positiveAmount = 252.0,
            status = StatusModel.POSITIVE
        ), modifier = Modifier)
    }
}
