package edu.wschina.b01.activity

import android.animation.ObjectAnimator
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.animation.doOnEnd
import edu.wschina.b01.R
import edu.wschina.b01.databinding.ActivityEactivityBinding

class EActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fromTime.setOnClickListener {

            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    binding.fromTime.text = "$p1 : $p2"
                }

            }, 0, 0, true).show()

        }

        binding.toTime.setOnClickListener {

            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    binding.toTime.text = "$p1 : $p2"
                }

            }, 0, 0, true).show()
        }

        binding.btnSubmit.setOnClickListener {

            if(binding.fromText.text.toString().isEmpty()){
                Toast.makeText(this,"请先填写出发地点",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(binding.fromTime.text.toString().isEmpty()){
                Toast.makeText(this,"请先获取出发时间",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(binding.toText.text.toString().isEmpty()){
                Toast.makeText(this,"请先填写到达地点",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(binding.toTime.text.toString().isEmpty()){
                Toast.makeText(this,"请先获取到达时间",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.visible.visibility = View.VISIBLE
            binding.hint.visibility = View.VISIBLE
            val objectAnimator = ObjectAnimator.ofFloat(binding.hint,"y",0f,binding.root.height/2f-binding.hint.height/2)
            objectAnimator.duration = 200
            objectAnimator.doOnEnd {
                binding.hintText.text = "出发地点：${binding.fromText.text}\n出发时间：${binding.fromTime.text}\n到达地点：${binding.toText.text}\n到达时间：${binding.toTime.text}"
            }
            objectAnimator.start()
        }
        binding.hintBtn.setOnClickListener {
            binding.visible.visibility = View.GONE
            binding.hint.visibility = View.INVISIBLE
            binding.hint.y = -200f
        }
    }
}