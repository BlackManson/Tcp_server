package com.example.myapplication

import android.os.*
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.Socket


class MainActivity : AppCompatActivity() {

    val IP = "192.168.8.102" // IP serwera na kompie napisany w python
    val PORT = "9001" // Port Serwera

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var thread = Thread(TcpServer(applicationContext))
        thread.start()
    }

    fun OnClick(v: View){
        val a =  TcpClient().execute(IP,PORT,"Wyslano z systemu android")
    }


}


