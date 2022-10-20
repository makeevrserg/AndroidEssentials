package com.makeevrserg.mvvmcore.core_compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.makeevrserg.mvvmcore.core.ui.UiText
import com.makeevrserg.mvvmcore.core.collectOn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

/**
 * Observe liveData in compose without passing a context
 */
@Composable
fun <T> LiveData<T>.Observe(observer: Observer<T>) {
    this.observe(LocalLifecycleOwner.current, observer)
}

/**
 * Compose support for [UiText]
 */
@Composable
fun UiText.asString(): String {
    return when (this) {
        is UiText.DynamicString -> value
        is UiText.StringResource -> stringResource(id = resId)
    }
}

/**
 * Compose support for collectOn method without passing a context
 */
//@Composable
//fun <T> Flow<T>.collectOn(
//    scope: CoroutineDispatcher = Dispatchers.Main,
//    action: suspend CoroutineScope.(value: T) -> Unit
//): Job = collectOn(LocalLifecycleOwner.current,scope,action)