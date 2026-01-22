package com.security.sdk.model

data class SecurityEvent(
    val api_key: String,
    val endpoint: String,
    val payload: String,
    val risk_score: Int
)