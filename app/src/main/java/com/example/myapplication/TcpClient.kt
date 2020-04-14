package com.example.myapplication

import android.os.AsyncTask
import android.widget.Toast
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket
import java.nio.charset.Charset


class TcpClient : AsyncTask<String?,Void,String>(){

    override fun doInBackground(vararg params: String?): String? {
        val ip = params[0]
        val port = params[1]
        val message = params[2]
        try
        {
            var s = Socket(ip, port!!.toInt())
            var dos = DataOutputStream(s.getOutputStream())
            if (message != null) {
                dos.write(message.toByteArray(Charset.defaultCharset()))
            }
            dos.close()
            s.close()
        }

        catch(e: IOException)
        {
            e.printStackTrace()
        }
        return null
    }


}
