package com.simple_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simple_recyclerview.model.Contacts
import com.simple_recyclerview.remote.ApiClient
import com.simple_recyclerview.remote.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView;

    val layoutManager = LinearLayoutManager(this)
    private var adapter: CustomAdapter? = null
    private var contactsList: List<Contacts>? = null
    private var apiInterface: ApiInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = layoutManager

        apiInterface = ApiClient().getApiClient()?.create(ApiInterface::class.java)

        fetchData()
    }
    fun fetchData(){
        val call = apiInterface?.getContact()
        call?.enqueue(object : Callback<List<Contacts?>?> {
            override fun onResponse(
                call: Call<List<Contacts?>?>?,
                response: Response<List<Contacts?>?>
            ) {
                contactsList = response.body() as List<Contacts>?
                adapter = CustomAdapter(this@MainActivity, contactsList!!)
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Contacts?>?>?, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error : $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}