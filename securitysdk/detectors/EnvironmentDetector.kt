package com.security.sdk.detectors

import android.os.Build
import android.os.Debug

object EnvironmentDetector {

    fun detect(): Int {
        var score = 0

        if (Debug.isDebuggerConnected()) score += 20

        if (
            Build.FINGERPRINT.contains("generic") ||
            Build.MODEL.contains("Emulator")
        ) {
            score += 20
        }

        return score
    }
}