package com.eslammongy.onlinecourses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.eslammongy.onlinecourses.adapter.CategoryAdapter
import com.eslammongy.onlinecourses.apiclient.RetrofitBuilder
import com.eslammongy.onlinecourses.databinding.ActivityHomePageBinding
import com.eslammongy.onlinecourses.model.CategoryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePage : AppCompatActivity() {
    private lateinit var binding:ActivityHomePageBinding

    private lateinit var categoriesList:ArrayList<CategoryModel>
    private var categoryAdapter:CategoryAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

            callingApi()
    }

    private fun callingApi(){
        val callCategoryApi:Call<List<CategoryModel>> = RetrofitBuilder.apiServices.getAllCategories()
        callCategoryApi.enqueue(object : Callback<List<CategoryModel>> {
            override fun onResponse(
                call: Call<List<CategoryModel>>,
                response: Response<List<CategoryModel>>
            ) {

                    categoriesList = response.body() as ArrayList<CategoryModel>
                    displayRecyclerView(categoriesList)

            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                Toast.makeText(this@HomePage , "No response from server ${t.localizedMessage} ", Toast.LENGTH_LONG).show()

            }
        })
    }

    private fun displayRecyclerView(listCategories:ArrayList<CategoryModel>){
        binding.courseRecycler.layoutManager = StaggeredGridLayoutManager(2 , 2)
        binding.courseRecycler.hasFixedSize()
        categoryAdapter = CategoryAdapter(this , listCategories)
        binding.courseRecycler.adapter = categoryAdapter
        categoryAdapter!!.notifyDataSetChanged()
    }
}

