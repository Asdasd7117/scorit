package com.security.sdk.detectors

import kotlin.math.ln

object BehaviorDetector {

    fun entropy(input: String): Double {
        if (input.isEmpty()) return 0.0
        val freq = input.groupingBy { it }.eachCount()
        return freq.values.sumOf {
            val p = it.toDouble() / input.length
            -p * ln(p)
        }
    }

    fun detect(payload: String): Int {
        return if (entropy(payload) > 3.5) 20 else 0
    }
}