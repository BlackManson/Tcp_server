package com.example.myapplication

import android.content.Context
import android.os.Handler
import android.widget.Toast
import java.io.DataInputStream
import java.io.IOException
import java.net.ServerSocket

class TcpServer(private val c: Context) : Runnable {
    var serverSocket = ServerSocket(9000)
    var handler = Handler()
    @ExperimentalStdlibApi
    override fun run() {
        try {
            //Looper.prepare()
            while (true){
                var socket = serverSocket.accept()
                var dis = DataInputStream(socket.getInputStream())
                var message = dis.readBytes() //Przypisz do zmiennej message ciag bytow wyslanych z klienta
                handler.post(Runnable(){
                    Toast.makeText(c,message.decodeToString(),Toast.LENGTH_SHORT).show() // przekonwertuj byte na ciag znaku i wyswietl w formie toastu
                })
            }
        }
        catch (e: IOException){
            e.printStackTrace()
        }
    }
}