package com.test.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.security.sdk.SecurityConfig
import com.security.sdk.SecuritySDK

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // تهيئة SDK
        SecuritySDK.init(
            SecurityConfig(
                serverUrl = "http://YOUR_SERVER_IP:3000/log",
                apiKey = "CLIENT_KEY_1"
            )
        )

        // تجربة حقن
        SecuritySDK.monitor(
            endpoint = "/login",
            payload = "admin' OR 1=1 --"
        )

        // تجربة سلوك غريب
        SecuritySDK.monitor(
            endpoint = "/search",
            payload = "%%%%%%%@@@@@@@#######$$$$$$"
        )
    }
}