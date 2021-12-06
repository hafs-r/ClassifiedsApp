package com.dubizzle.classifieds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.dubizzle.classifieds.presentation.main.MainScreenView
import org.koin.android.viewmodel.ext.android.viewModel
import com.dubizzle.classifieds.presentation.main.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadClassifieds()
        setContent {
            MainScreenView(viewModel)
        }
    }
}