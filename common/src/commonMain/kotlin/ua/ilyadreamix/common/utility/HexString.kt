package ua.ilyadreamix.common.utility

fun Int.hexToString() = String.format("#%06X", 0xFFFFFF and this)
