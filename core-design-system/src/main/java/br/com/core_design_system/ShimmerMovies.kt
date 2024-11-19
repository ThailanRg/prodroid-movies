package br.com.core_design_system

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.core_kotlin.shimmerEffects

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


