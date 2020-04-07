package id.ac.unhas.infocovid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import id.ac.unhas.infocovid19.ui.harian.HarianListFragment
import id.ac.unhas.infocovid19.ui.kasus.KasusListFragment
import id.ac.unhas.infocovid19.ui.provinsi.ProvinsiListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var provinsiButton: Button
    private lateinit var harianButton: Button
    private lateinit var kasusButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        provinsiButton = findViewById(R.id.provinsi)
        kasusButton = findViewById(R.id.kasus)
        harianButton = findViewById(R.id.harian)

        provinsiButton.setOnClickListener {
            Log.d("MainActivity", "Test2")
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProvinsiListFragment.newInstance())
                    .commitNow()
            }
        }

        harianButton.setOnClickListener {
            Log.d("MainActivity", "Test2")
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HarianListFragment.newInstance())
                    .commitNow()
            }
        }

        kasusButton.setOnClickListener {
            Log.d("MainActivity", "Test2")
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, KasusListFragment.newInstance())
                    .commitNow()
            }
        }

    }
}