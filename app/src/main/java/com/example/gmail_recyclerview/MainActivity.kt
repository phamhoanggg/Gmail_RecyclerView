package com.example.gmail_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private val items: ArrayList<GmailModel> = arrayListOf()
    private val mAdapter: Adapter = Adapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.menu)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        repeat(10) {
            items.add(
                GmailModel(
                    sender = "hello.com",
                    title = "This is your change to do something very very very important!!!",
                    content = "Today we announce something very important for you this is your change to take an advantage of cat",
                    time = "12:30 AM",
                    logoPath = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfGr1do83pQvvYqz4mCXOr2xRbP5QP2Z5k2A&usqp=CAU",
                    isMark = false
                )
            )
        }

        findViewById<ListView>(R.id.list_view).adapter = mAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }
}