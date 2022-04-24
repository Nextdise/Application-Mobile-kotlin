package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

private  lateinit var ideeAdapter : IdeeAdapter

class List2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        ideeAdapter = IdeeAdapter(mutableListOf())
        rvIdeeItems.adapter = ideeAdapter
        rvIdeeItems.layoutManager= LinearLayoutManager(this)

        btnIdeeTitle.setOnClickListener{
            val ideeTitle = etIdeeTitle.text.toString()
            if(ideeTitle.isNotEmpty()) {
                val idee = Idee(ideeTitle)
                ideeAdapter.addIdee(idee)
                etIdeeTitle.text.clear()
            }

        }
        btnDeleteIdeeTitle.setOnClickListener{
            ideeAdapter.deleteDoneIdee()
        }
    }

}