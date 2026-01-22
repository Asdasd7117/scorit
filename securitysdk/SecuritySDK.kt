package com.security.sdk

import com.security.sdk.detectors.*
import com.security.sdk.model.SecurityEvent

object SecuritySDK {

    private lateinit var config: SecurityConfig

    fun init(securityConfig: SecurityConfig) {
        config = securityConfig
    }

    fun monitor(endpoint: String, payload: String) {
        var risk = 0

        risk += InjectionDetector.detect(payload)
        risk += BehaviorDetector.detect(payload)
        risk += EnvironmentDetector.detect()

        val event = SecurityEvent(
            api_key = config.apiKey,
            endpoint = endpoint,
            payload = payload,
            risk_score = risk
        )

        NetworkClient.send(config, event)
    }
}