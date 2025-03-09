package com.example.service_adr

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message

class MyService : Service() {

    private var serviceHandler: ServiceHandler? = null
    private var serviceLooper: Looper? = null
    private var serviceCounter:Int = 0

    private inner class ServiceHandler(looper: Looper): Handler(looper)
    {
        override fun handleMessage(msg: Message) {
            try {
                Thread.sleep(5000)
            }
            catch (e: InterruptedException)
            {
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1)
        }
    }

    override fun onBind(intent: Intent): IBinder?{
        return null
    }

    companion object {
        const val EXTRA_SERVICE_COUNTER = "EXTRA_SERVICE_COUNTER"

    }
}