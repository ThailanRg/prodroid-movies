package br.com.core_design_system

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.core_kotlin.shimmerEffects

@Composable
fun ShimmerMovie(
    isLoading: Boolean = false,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        Row(
            modifier = modifier.padding(18.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(100.dp)
                    .shimmerEffects()
            )
            Column(
                modifier = Modifier.padding(start = br.com.core_design_system.CustomDimens.dimens.spaceSection),
                verticalArrangement = Arrangement.spacedBy(br.com.core_design_system.CustomDimens.dimens.spaceSection)
            ) {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .shimmerEffects())

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .shimmerEffects())

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .shimmerEffects())

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .shimmerEffects())
            }
        }
    } else {
        contentAfterLoading()
    }
}


