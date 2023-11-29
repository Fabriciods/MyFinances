package com.fabricioao.myfinances.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fabricioao.myfinances.presentation.home.components.Balance
import com.fabricioao.myfinances.presentation.home.components.HeaderTitle
import com.fabricioao.myfinances.presentation.ui.theme.MyFinancesTheme

@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderTitle(userName = "Fabricio",
            { })
        Balance(balance = 3.1)

    }
}
@Composable
@Preview
fun preview(){
    MyFinancesTheme {
        HomeScreen()
    }
}


