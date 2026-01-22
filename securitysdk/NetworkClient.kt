package com.security.sdk

import com.security.sdk.model.SecurityEvent
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

object NetworkClient {

    fun send(config: SecurityConfig, event: SecurityEvent) {
        thread {
            try {
                val url = URL(config.serverUrl)
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.setRequestProperty("Content-Type", "application/json")
                conn.doOutput = true

                val json = JSONObject().apply {
                    put("api_key", event.api_key)
                    put("endpoint", event.endpoint)
                    put("payload", event.payload)
                    put("risk_score", event.risk_score)
                }

                conn.outputStream.use {
                    it.write(json.toString().toByteArray())
                }

                conn.inputStream.close()
                conn.disconnect()
            } catch (_: Exception) {}
        }
    }
}