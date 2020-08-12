package com.pm.requestdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EmployeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(recyclerview.context,
                layoutManager.orientation)
        recyclerview.addItemDecoration(dividerItemDecoration)

        /*button.setOnClickListener {
            Log.d("Sometag", "Clicked")
            //makeRequest()
        }*/

        viewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        viewModel.liveData.observe(this,
            Observer { items ->
                Log.d(TAG, "Have items from ViewModel $items")
                recyclerview.adapter = CustomAdapter(items)
            }
        )
    }
}