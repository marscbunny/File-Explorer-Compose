package com.raival.compose.file.explorer.screen.main.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raival.compose.file.explorer.App.Companion.globalClass
import com.raival.compose.file.explorer.screen.main.tab.regular.RegularTab
import com.raival.compose.file.explorer.screen.main.tab.regular.compose.RegularTabHeaderView

@Composable
fun TabLayout() {
    val mainActivityManager = globalClass.mainActivityManager
    val tabLayoutState = rememberLazyListState()

    Row(
        Modifier
            .fillMaxWidth()
            .height(42.dp)
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        IconButton(
            onClick = {
                mainActivityManager.showNewTabDialog = true
            }
        ) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
        }

        LazyRow(
            modifier = Modifier.fillMaxSize(),
            state = tabLayoutState,
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemsIndexed(mainActivityManager.tabs, key = { _, item -> item.id }) { index, tab ->
                if (tab is RegularTab) {
                    RegularTabHeaderView(
                        tab = tab,
                        isSelected = mainActivityManager.tabs[mainActivityManager.selectedTabIndex] == tab,
                        index = index,
                    )
                }
            }
        }
    }
}