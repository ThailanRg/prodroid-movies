package com.example.prodroidmovielist.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Immutable
data class Dimens(
    val horizontalContainerPadding : Dp = 16.dp,
    val containerPadding : Dp = 16.dp,
    val spaceSection : Dp = 8.dp,
    val verticalContainerPadding : Dp = 16.dp,
    val spaceBy : Dp = 16.dp,
    val spaceBySmall : Dp = 8.dp,
)

internal val LocalDimens = staticCompositionLocalOf { Dimens() }

object CustomDimens {
    val dimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current
}