package com.example.webservicesusinggsondemo1

import android.os.AsyncTask
import android.os.Handler
import android.os.Message

class WebThread(private val handler: Handler) : AsyncTask<Any, Any, APIResponse>(){
    override fun doInBackground(vararg params: Any?): APIResponse {
        return WebUtil.getUsers(1)
    }

    override fun onPostExecute(result: APIResponse?) {
        super.onPostExecute(result)

        val message = Message()
        message.obj = result
        handler.sendMessage(message)
    }
}