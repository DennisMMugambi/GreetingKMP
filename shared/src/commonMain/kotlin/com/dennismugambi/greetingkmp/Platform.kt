package com.dennismugambi.greetingkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform