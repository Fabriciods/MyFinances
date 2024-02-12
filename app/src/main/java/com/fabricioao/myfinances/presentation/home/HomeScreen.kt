package com.fabricioao.myfinances.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabricioao.myfinances.presentation.home.components.BalanceCompose
import com.fabricioao.myfinances.presentation.home.components.HeaderTitle
import com.fabricioao.myfinances.presentation.home.components.MonthBalanceComposable
import com.fabricioao.myfinances.presentation.home.components.RecurrenceDisplay
import com.fabricioao.myfinances.presentation.ui.theme.MyFinancesTheme
import com.fabricioao.myfinances.presentation.ui.theme.White

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    HomeContent(homeViewModel = homeViewModel, modifier)
}

@Composable
private fun HomeContent(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        HeaderTitle(userName = homeViewModel.userModel.name,
            { //TODO deve abrir as notificações
            })

        BalanceCompose(modifier = Modifier.padding(vertical = 24.dp),balance = homeViewModel.balance)
        MonthBalanceComposable(mountBalance = homeViewModel.mountBalance)
        homeViewModel.recurrenceList.takeIf { it.isNotEmpty() }?.let { list ->
            Column {
                Text(
                    text = "Próximas Movimentações",
                    color = White,
                    modifier = Modifier.padding(start = 8.dp)
                )
                list.forEach {
                    RecurrenceDisplay(recurrence = it,
                        modifier = Modifier.padding(top= 8.dp))
                }
            }
        }


    }
}

@Composable
@Preview
fun preview() {
    MyFinancesTheme {
        HomeScreen(homeViewModel = HomeViewModel())
    }
}


