package edu.wschina.b01.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import edu.wschina.b01.R

class GuidAdapter(private val list: List<Int>) : PagerAdapter() {

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_guid_view,container,false)
        val text = view.findViewById<TextView>(R.id.guid_item_text)
        val img = view.findViewById<ImageView>(R.id.guid_item_image)
        img.setImageResource(list[position])
        when(position){
            0->{
                text.text = "刷马成功，行业领先"
            }
            1->{
                text.text = "内置商城，专享优惠"
            }
            2->{
                text.text = "视觉优化，全新体验"
            }
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}