package com.tamimapps.test

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.UnsupportedEncodingException


class MainActivity : AppCompatActivity() {
    private var adapter: ItemsRecyclerAdapter? = null
    private var request: JsonArrayRequest? = null
    private var requestQueue: RequestQueue? = null
    private var itemList: ArrayList<Items>? = null


    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.listView)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        itemList = ArrayList()
        requestQueue = Volley.newRequestQueue(this)


        parce()
    }

    private fun parce() {
        val url: String =
            "http://fawazabbas.com/coins/api/get_posts/"
        val request: JsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener {
                try {
                    val jsonArray = it.getJSONArray("posts")
                    for (i in 0 until jsonArray.length()) {
                        val user = jsonArray.getJSONObject(i)
                        val name = user.getString("slug")
                        val thumb = user.getJSONObject("thumbnail_images").getJSONObject("full")
                            .getString("url").toString()
                        val date = user.getString("date")
                        itemList!!.add(Items(null, name, thumb, date))
                    }
                    adapter = ItemsRecyclerAdapter(this, itemList!!)
                    recyclerView!!.adapter = adapter
                    adapter!!.notifyDataSetChanged()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener {
                it.printStackTrace()
            })
        requestQueue!!.add(request)
    }


}