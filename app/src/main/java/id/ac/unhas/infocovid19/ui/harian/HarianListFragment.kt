package id.ac.unhas.infocovid19.ui.harian

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
import id.ac.unhas.infocovid19.model.DataHarian
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.network.ApiEndPoint
import id.ac.unhas.infocovid19.model.Harian
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HarianListFragment : Fragment() {

    companion object {
        fun newInstance() = HarianListFragment()
    }

    private lateinit var viewModel: HarianViewModel
    private lateinit var viewModelFactory: HarianViewModelFactory

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.harianlist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainFragment", "createView")
        listView = view.findViewById(R.id.list_view_harian)

        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()

        var apiEndPoint = retrofit.create(ApiEndPoint::class.java)

        apiEndPoint.getDataHarian().enqueue(object : Callback<DataHarian> {
            override fun onFailure(call: Call<DataHarian>, t: Throwable) {
                Log.e(this::class.java.simpleName, "Error: ${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<DataHarian>, response: Response<DataHarian>) {
                val dataHarian = response.body()?.data

                val adapter = context?.let {
                    ArrayAdapter(
                        it,
                        R.layout.listview_item_harian,
                        toListOfStrings(dataHarian)
                    )
                }

                listView.adapter = adapter
            }
        })
    }

    private fun toListOfStrings(dataHarian: List<Harian?>?): Array<String?> {
        val listItems = arrayOfNulls<String>(dataHarian?.size ?: 0)

        dataHarian?.forEachIndexed { index, harian ->
            listItems[index] = harian.toString()
        }

        return listItems
    }
}
