package xyz.ihudapp.crudandroidfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dao = Dao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_enviar.setOnClickListener {
            val byLearn = ByLearn()
            byLearn.site = main_site.text.toString()
            main_site.text = null

            byLearn.blog = main_blog.text.toString()
            main_blog.text = null

            dao.salvar(byLearn)
        }

    }

    override fun onResume() {
        super.onResume()

        dao.getByLearn {
            main_site.setText(it?.site?:"")
            main_blog.setText(it?.blog?:"")
        }
    }
}
