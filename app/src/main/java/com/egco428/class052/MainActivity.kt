package com.egco428.class052

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import java.security.AccessControlContext
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_listView.adapter = myCustomAdapter(this)
    }

    private class myCustomAdapter(context: Context):BaseAdapter(){
        private val mContext: Context
        val names = arrayListOf<String>("Sunny","AA","BB","Sunny","AA","BB","Sunny","AA","BB","Sunny","AA","BB","Sunny","AA","BB","Sunny","AA","BB","Sunny","AA","BB","Sunny","AA","BB","Sunny","AA","BB")
        init {
            mContext = context
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        } //have to convert to long

        override fun getItem(p0: Int): Any {
            return "result"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
           // val yellowColor = Color.parseColor("#FFFF00")
            val greyColor = Color.parseColor("#E0E0E0")
            val whiteColor = Color.parseColor("#FFFFFF")
            val layoutInflator = LayoutInflater.from(mContext)
            val rowMain = layoutInflator.inflate(R.layout.row_main,viewGroup,false)
            Log.d("Result","Load Name_TextView")
            rowMain.name_textView.text = names.get(position)
            Log.d("Result","Load Posistion_Textview")
            rowMain.position_textView.text = "Row Number: $position"

            if(position%2 == 1){
                rowMain.setBackgroundColor(greyColor)
            }
            else{
                rowMain.setBackgroundColor(whiteColor)
            }

            return rowMain

        }
    }
}
