package tw.hankli.activitylaunchmodedemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity.*

class ThirdActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val i = Intent(context, ThirdActivity::class.java)
            context.startActivity(i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        // show the class name
        view_txt.text = this::class.java.simpleName

        // start MainActivity
        view_btn1.setOnClickListener { MainActivity.start(this) }

        // start SecondActivity
        view_btn2.setOnClickListener { SecondActivity.start(this) }

        // start ThirdActivity
        view_btn3.setOnClickListener { ThirdActivity.start(this) }
    }
}
