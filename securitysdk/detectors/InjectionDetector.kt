package com.security.sdk.detectors

object InjectionDetector {

    private val patterns = listOf(
        "union select",
        "or 1=1",
        "drop table",
        "<script>",
        "../"
    )

    fun detect(payload: String): Int {
        var score = 0
        val lower = payload.lowercase()

        for (p in patterns) {
            if (lower.contains(p)) {
                score += 25
            }
        }
        return score
    }
}