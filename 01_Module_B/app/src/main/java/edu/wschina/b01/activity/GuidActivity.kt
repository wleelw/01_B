package edu.wschina.b01.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import edu.wschina.b01.R
import edu.wschina.b01.adapter.GuidAdapter
import edu.wschina.b01.databinding.ActivityGuidBinding

class GuidActivity : AppCompatActivity() {
    private lateinit var binding :ActivityGuidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shared = getSharedPreferences("guid_info", MODE_PRIVATE)
        if(!shared.getBoolean("isDisplay",true)){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        val list = listOf(R.drawable.sucess,R.drawable.not_find,R.drawable.resource_null)

        binding.guidView.adapter = GuidAdapter(list)

        binding.guidView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                getResourceImage(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        binding.one.setOnClickListener{

            getResourceImage(0)
            binding.guidView.currentItem = 0
        }
        binding.two.setOnClickListener{
            getResourceImage(1)
            binding.guidView.currentItem = 1
        }
        binding.three.setOnClickListener{
            getResourceImage(2)
            binding.guidView.currentItem = 2

        }

        binding.btnActivity.setOnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

            val shared = getSharedPreferences("guid_info", MODE_PRIVATE)
            val edit = shared.edit()
            edit.apply {
                putBoolean("isDisplay",false)
            }.apply()

            finish()
        }

    }

    private fun getResourceImage(id: Int) {
        binding.one.setImageResource(R.drawable.ic_yuan)
        binding.two.setImageResource(R.drawable.ic_yuan)
        binding.three.setImageResource(R.drawable.ic_yuan)
        when (id) {
            0 -> {
                binding.btnActivity.visibility = View.GONE
                binding.one.setImageResource(R.drawable.ic_yuan_red)
            }
            1 -> {
                binding.btnActivity.visibility = View.GONE
                binding.two.setImageResource(R.drawable.ic_yuan_red)
            }
            2 -> {
                binding.btnActivity.visibility = View.VISIBLE
                binding.three.setImageResource(R.drawable.ic_yuan_red)
            }
        }
    }
}