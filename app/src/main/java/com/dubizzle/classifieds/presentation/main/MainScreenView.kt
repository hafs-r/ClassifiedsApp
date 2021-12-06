package com.dubizzle.classifieds.presentation.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dubizzle.classifieds.data.main.model.Classified

@Composable
fun MainScreenView(viewModel: MainViewModel) {

    val items = viewModel.classifieds.observeAsState(emptyList())
    LazyColumn {
        items(items = items.value, itemContent = { data ->
            ClassifiedWidget(data)
        })
    }
}

@Composable
fun ClassifiedWidget(classified: Classified) {
    Column {
        Log.e("TY",classified.name+"%%%")
        BasicText(text = classified.name)
        BasicText(text = classified.price)
        Image(
            painter = rememberImagePainter(classified.image_urls_thumbnails[0]),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
    }
}

data class MainUiState(
    var data: List<Classified> = emptyList(),
    var loading: Boolean = false
)