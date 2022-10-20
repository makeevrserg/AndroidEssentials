package com.makeevrserg.mvvmcore.core.ui

import android.content.Context
import androidx.annotation.StringRes

/**
 * This class allows to create messages from ViewModel without context
 * The compose integration also avaliable in core-compose
 */
sealed class UiText {
    companion object {
        operator fun invoke(
            resId: Int,
            vararg args: Pair<String, String>
        ): UiText = StringResource(resId, *args)
    }

    /**
     * Сюда можно запихнуть обычный String при необходимости
     */
    data class DynamicString(val value: String) : UiText()

    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Pair<String, String>
    ) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(resId)
        }
    }

    /**
     * Если у текста есть аргументы вроде %name% - в [args] можно передать например %name% to user.name
     */
    fun withArgs(line: String, vararg args: Pair<String, String>): String {
        var line = line
        args.forEach {
            line = line.replace(it.first, it.second)
        }
        return line
    }
}