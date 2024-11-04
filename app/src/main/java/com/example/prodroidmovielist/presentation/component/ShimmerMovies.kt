package com.example.prodroidmovielist.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prodroidmovielist.core.utils.shimmerEffects

@Composable
fun ShimmerMovies(
    isLoading: Boolean = false,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .shimmerEffects()
    )
}


