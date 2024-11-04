package com.example.prodroidmovielist.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prodroidmovielist.core.utils.shimmerEffects
import com.example.prodroidmovielist.presentation.theme.CustomDimens

@Composable
fun ShimmerMovies(
    isLoading: Boolean = false,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy),
            horizontalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy),
            contentPadding = PaddingValues(CustomDimens.dimens.containerPadding)
        ) {
            items(
                count = 8,
                itemContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .shimmerEffects()
                    )
                })
        }
    } else {
        contentAfterLoading()
    }
}


