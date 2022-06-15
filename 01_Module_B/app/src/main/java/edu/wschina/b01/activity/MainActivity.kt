package edu.wschina.b01.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import edu.wschina.b01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginSubmit.setOnClickListener {

            if(binding.textPhone.text.toString().isEmpty()||binding.textCode.text.toString().isEmpty()){
                Toast.makeText(this,"请填写完整信息",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(binding.check.isChecked){
                // 实现转场动画
                val bundle =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this, binding.title, "title")
                        .toBundle()
                val intent = Intent(this,EActivity::class.java)
                startActivity(intent,bundle)
            }
            else{
                Toast.makeText(this,"请先同意协议",Toast.LENGTH_LONG).show()
            }

        }
    }
}