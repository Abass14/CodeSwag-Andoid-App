package com.example.coderswag.Adapters

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Category
import com.example.coderswag.R

class CategoryAdapter(context: Context, categories: List<Category>): BaseAdapter() {
    val context = context
    val categories = categories
    override fun getCount(): Int {
        //COUNT OF LIST ITEMS IN CATEGPRY
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        //POSITION OF EACH CATEGORIES IN CATEGORY CLASS
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder
        var categoryView: View

        if (convertView == null){
            //INFLATING/CONNECTING THE CATEGORY_LIST_ITEM LAYOUT AS VIEW
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            //BRINGING IN THE UI ELEMENTS IN CATEGORY_LIST_ITEM BY ID FINDER
            holder.categoryImage = categoryView.findViewById<ImageView>(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById<TextView>(R.id.categoryText)

            categoryView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }
//        //INFLATING/CONNECTING THE CATEGORY_LIST_ITEM LAYOUT AS VIEW
//        val categoryView: View = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
//        //BRINGING IN THE UI ELEMENTS IN CATEGORY_LIST_ITEM BY ID FINDER
//        val categoryImage = categoryView.findViewById<ImageView>(R.id.categoryImage)
//        val categoryName = categoryView.findViewById<TextView>(R.id.categoryText)
//        //Bringing in each categories item at respective positions
        val category = categories[position]

        holder.categoryName?.text  = category.title

        //SETTING THE DRAWABLE PICTURES IN LAYOUT TO A RESOURCE ID
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)

        //RETURNING THE VIEW
        return categoryView
    }

    private class ViewHolder{
        var categoryName: TextView? = null
        var categoryImage: ImageView? = null
    }
}