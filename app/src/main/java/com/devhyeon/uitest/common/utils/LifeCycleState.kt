package com.devhyeon.uitest.common.utils

import androidx.lifecycle.Lifecycle

fun Lifecycle.isInitialized() : Boolean {
    return this.currentState.isAtLeast(Lifecycle.State.INITIALIZED)
}

fun Lifecycle.isCreated() : Boolean {
    return this.currentState.isAtLeast(Lifecycle.State.CREATED)
}

fun Lifecycle.isStarted() : Boolean {
    return this.currentState.isAtLeast(Lifecycle.State.STARTED)
}

fun Lifecycle.isResumed() : Boolean {
    return this.currentState.isAtLeast(Lifecycle.State.RESUMED)
}

fun Lifecycle.isDestroyed() : Boolean {
    return this.currentState.isAtLeast(Lifecycle.State.DESTROYED)
}
