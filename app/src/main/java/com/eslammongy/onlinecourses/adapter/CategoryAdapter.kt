package com.eslammongy.onlinecourses.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eslammongy.onlinecourses.databinding.CategoryListItemBinding
import com.eslammongy.onlinecourses.model.CategoryModel

class CategoryAdapter(private val context: Context, private var listOfCategories:List<CategoryModel>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryListItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       val categoryModel = listOfCategories[position]
        holder.binding.categoryName.text = categoryModel.categoryName
        holder.binding.totalCourse.text = categoryModel.totalCourses
        Glide.with(context).load(categoryModel.image).into(holder.binding.categoryImage).clearOnDetach()

    }

    override fun getItemCount(): Int {
        return listOfCategories.size
    }

    class CategoryViewHolder(val binding: CategoryListItemBinding):RecyclerView.ViewHolder(binding.root)

}