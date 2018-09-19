package example.yancey.application1

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShow = findViewById<Button>(R.id.button)
        val btnShow2 = findViewById<Button>(R.id.button2)
        val txtShow = findViewById<EditText>(R.id.editText)
        val viewShow = findViewById<TextView>(R.id.textView)
        val viewRval = findViewById<TextView>(R.id.textViewRGB)
        btnShow?.setOnClickListener{
            val random = Random()
            // create a big random number - maximum is ffffff (hex) = 16777215 (dez)
            val nextInt = random.nextInt(0xffffff + 1)
            // format it as hexadecimal string (with hashtag and leading zeros)
            val colorCode = String.format("#%06X", nextInt)

            //parse out hex color code
            val rValues = colorCode.substring(1, 3)
            val gValues = colorCode.substring(3, 5)
            val bValues = colorCode.substring(5, 7)

            //convert hex color code to decimal
            val rVal = Integer.parseInt(rValues, 16)
            val gVal = Integer.parseInt(gValues, 16)
            val bVal = Integer.parseInt(bValues, 16)

            //txtShow.clearFocus()
            //change EditText color value
            txtShow.setTextColor(Color.parseColor(colorCode))
            //show hex value of color
            viewShow.setText(colorCode)

            //display rgb values
            viewRval.setText("COLOR: " + rVal.toString() + "r, " + gVal.toString() + "g, " + bVal.toString() + "b")
        }

        btnShow2?.setOnClickListener{
            // Create an Intent to start the second activity
            val randomIntent = Intent(this, Main2Activity::class.java)

            // Start the new activity.
            startActivity(randomIntent)

        }
    }
}
