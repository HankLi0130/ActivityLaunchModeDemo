package tw.hankli.activitylaunchmodedemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity.*

class B : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val i = Intent(context, B::class.java)
            context.startActivity(i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        // show the class name
        view_txt.text = this::class.java.simpleName

        // start A
        view_btn1.setOnClickListener { A.start(this) }

        // start B
        view_btn2.setOnClickListener { B.start(this) }

        // start C
        view_btn3.setOnClickListener { C.start(this) }
    }
}
