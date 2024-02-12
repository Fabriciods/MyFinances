package com.fabricioao.myfinances.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabricioao.myfinances.R
import com.fabricioao.myfinances.presentation.ui.theme.BlueLight
import com.fabricioao.myfinances.presentation.ui.theme.MyFinancesTheme
import com.fabricioao.myfinances.presentation.ui.theme.White

@Composable
fun HeaderTitle(
    userName: String,
    onClickMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        color = BlueLight
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = stringResource(R.string.my_finances_header_hello, userName),
                color = White
            )
            IconButton(onClick = onClickMenu) {
                Image(imageVector = Icons.Sharp.Notifications,
                    contentDescription = stringResource(R.string.my_finances_content_description_menu),
                    colorFilter = ColorFilter.tint(White))
            }
        }

    }
}
@Composable
@Preview
fun HeaderPreview(){
    MyFinancesTheme {
        HeaderTitle(userName = "Fabricio", onClickMenu = { /*TODO*/ })
    }
}