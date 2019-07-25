package devarthur4718.com.multilanguagesupport

import android.content.DialogInterface
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnChange.setOnClickListener { showDialogLanguague() }
    }

    private fun showDialogLanguague() {

        val listItems = arrayOf("English", "Português", "Espanõl")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language...")

        mBuilder.setSingleChoiceItems(listItems, -1) { dialog, which ->
            if (which == 0) {

                setLocale("en")
                recreate()
            } else if (which == 1) {

                setLocale("pt-br")
                recreate()

            } else if (which == 2) {
                setLocale("es")
                recreate()
            }


            //dismiss alert
            dialog.dismiss()
        }


    }

    private fun setLocale(lang: String) {

        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()

        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

    }

}
