package com.example.webservicesusinggsondemo1

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webservicesusinggsondemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private var users = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        initAdapter()
        WebThread(UserHandler()).execute()


    }
    private fun initAdapter(){
        userAdapter = UserAdapter(users)
        activityMainBinding.usersRecyclerView.adapter = userAdapter
        activityMainBinding.usersRecyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)

    }
    inner class UserHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.obj != null){
                Toast.makeText(this@MainActivity,"Msg Obj -> ${msg.obj}", Toast.LENGTH_LONG).show()
            }
            val User = msg.obj as ArrayList<User>
            this@MainActivity.users.addAll(users)
            userAdapter.notifyDataSetChanged()

            for(i in users){
                Log.e("Tag","$i")
            }
        }
    }
}