package com.fabricioao.myfinances.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabricioao.myfinances.R
import com.fabricioao.myfinances.presentation.ui.theme.Black
import com.fabricioao.myfinances.presentation.ui.theme.MyFinancesTheme
import com.fabricioao.myfinances.utils.toCurrency

@Composable
fun BalanceCompose(
    balance: Double,
    modifier: Modifier = Modifier
) {
    var isVisible by remember {
        mutableStateOf(true)
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(R.string.my_finances_balance_actual),
                    color = Black
                )
            if (isVisible)
                Text(
                    text = balance.toCurrency(),
                    color = Black
                )
            else
                Box(modifier = Modifier
                    .background(Color.White)
                    .size(width = 60.dp, height = 20.dp))
        }
        IconButton(onClick = { isVisible = !isVisible }) {
            ResolveIcon(isVisible = isVisible)
        }
    }
}

@Composable
private fun ResolveIcon(isVisible: Boolean) {
    return if (isVisible)
        Image(
            painter = painterResource(id = R.drawable.ic_visibility_on),
            contentDescription =
            stringResource(R.string.my_finances_content_description_balance_display_on),
            colorFilter = ColorFilter.tint(Color.Black)
        )
    else
        Image(
            painter = painterResource(id = R.drawable.ic_visibility_off),
            contentDescription = stringResource(R.string.my_finances_content_description_balance_display_off),
            colorFilter = ColorFilter.tint(Color.Black)
        )
}
@Composable
@Preview
fun Preview(){
    MyFinancesTheme {
        BalanceCompose(balance = 23.4)
    }
}