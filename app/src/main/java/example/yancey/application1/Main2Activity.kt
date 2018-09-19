package example.yancey.application1

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Button
import com.pes.androidmaterialcolorpickerdialog.ColorPicker
import kotlinx.android.synthetic.main.activity_main2.*
import tech.picnic.fingerpaintview.FingerPaintImageView
import java.io.File
import java.io.FileOutputStream
import java.util.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnShow = findViewById<Button>(R.id.button3)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnUndo = findViewById<Button>(R.id.btnUndo)
        val btnSelect = findViewById<Button>(R.id.btnSelect)

        val canvas1 = findViewById<FingerPaintImageView>(R.id.finger)
        canvas1.strokeColor = Color.rgb(0,0,0)

        btnShow?.setOnClickListener {
            finish()
        }

        btnClear?.setOnClickListener {
            canvas1.clear()
        }

        btnUndo?.setOnClickListener {
            canvas1.undo()
        }

        btnSelect?.setOnClickListener {

            val cp = ColorPicker(this, 0, 0, 0)

            cp.show()
            cp.enableAutoClose()
            cp.setCallback { color ->
                // Do whatever you want
                // Examples
                Log.d("Alpha", Integer.toString(Color.alpha(color)))
                Log.d("Red", Integer.toString(Color.red(color)))
                Log.d("Green", Integer.toString(Color.green(color)))
                Log.d("Blue", Integer.toString(Color.blue(color)))

                Log.d("Pure Hex", Integer.toHexString(color))
                Log.d("#Hex no alpha", String.format("#%06X", 0xFFFFFF and color))
                Log.d("#Hex with alpha", String.format("#%08X", -0x1 and color))

                var color1 = Color.rgb(Color.red(color), Color.green(color), Color.blue(color))
                canvas1.strokeColor = color1
                // If the auto-dismiss option is not enable (disabled as default) you have to manually dimiss the dialog
                // cp.dismiss();
            }
        }

        btnSave?.setOnClickListener {
            val picture = canvas1.drawable as BitmapDrawable
            permissionsCheck()
            save(picture.bitmap)
        }
    }

    private fun save(finalBitmap: Bitmap) {

        val root = Environment.getExternalStorageDirectory().toString()
        val myDir = File(root + "/saved_images")
        myDir.mkdirs()
        val generator = Random()
        var n = 10000
        n = generator.nextInt(n)
        val fname = "Image-$n.jpg"
        val file = File(myDir, fname)
        if (file.exists()) file.delete()
        try {
            val out = FileOutputStream(file)
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
            out.flush()
            out.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            2 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d("test6", "test6")
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Log.d("test7", "test7")
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }

    fun permissionsCheck() {
        Log.d("test", "test")
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.d("test2", "test2")
            } else {
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        2)
                Log.d("test3", "test3")
            }
        } else {
            // Permission has been granted
        }
    }
}

