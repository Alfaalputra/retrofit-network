package id.ac.unhas.infocovid19.ui.kasus

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import id.ac.unhas.infocovid19.BuildConfig
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.DataKasus
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.Kasus
import id.ac.unhas.infocovid19.network.ApiEndPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KasusListFragment : Fragment() {

    companion object {
        fun newInstance() = KasusListFragment()
    }

    private lateinit var viewModel: KasusViewModel
    private lateinit var viewModelFactory: KasusViewModelFactory

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.kasuslist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainFragment", "createView")
        listView = view.findViewById(R.id.list_view_kasus)

        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()

        var apiEndPoint = retrofit.create(ApiEndPoint::class.java)

        apiEndPoint.getDataKasus().enqueue(object : Callback<DataKasus> {
            override fun onFailure(call: Call<DataKasus>, t: Throwable) {
                Log.e(this::class.java.simpleName, "Error: ${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<DataKasus>, response: Response<DataKasus>) {
                val dataKasus = response.body()?.data

                val adapter = context?.let {
                    ArrayAdapter(
                        it,
                        R.layout.listview_item_kasus,
                        toListOfStrings(dataKasus)
                    )
                }

                listView.adapter = adapter
            }
        })
    }

    private fun toListOfStrings(dataKasus: List<Kasus?>?): Array<String?> {
        val listItems = arrayOfNulls<String>(dataKasus?.size ?: 0)

        dataKasus?.forEachIndexed { index, kasus ->
            listItems[index] = kasus.toString()
        }

        return listItems
    }
}