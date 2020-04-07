package id.ac.unhas.infocovid19.ui.provinsi

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
import id.ac.unhas.infocovid19.model.DataProvinsi
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.network.ApiEndPoint
import id.ac.unhas.infocovid19.model.Provinsi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProvinsiListFragment : Fragment() {

    companion object {
        fun newInstance() = ProvinsiListFragment()
    }

    private lateinit var viewModel: ProvinsiViewModel
    private lateinit var viewModelFactory: ProvinsiViewModelFactory

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.provinsilist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainFragment", "createView")
        listView = view.findViewById(R.id.list_view_provinsi)

        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()

        var apiEndPoint = retrofit.create(ApiEndPoint::class.java)

        apiEndPoint.getDataProvinsi().enqueue(object : Callback<DataProvinsi> {
            override fun onFailure(call: Call<DataProvinsi>, t: Throwable) {
                Log.e(this::class.java.simpleName, "Error: ${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<DataProvinsi>, response: Response<DataProvinsi>) {
                val dataProvinsi = response.body()?.data

                val adapter = context?.let {
                    ArrayAdapter(
                        it,
                        R.layout.listview_item_provinsi,
                        toListOfStrings(dataProvinsi)
                    )
                }

                listView.adapter = adapter
            }
        })
    }

    private fun toListOfStrings(dataProvinsi: List<Provinsi?>?): Array<String?> {
        val listItems = arrayOfNulls<String>(dataProvinsi?.size ?: 0)

        dataProvinsi?.forEachIndexed { index, provinsi ->
            listItems[index] = provinsi.toString()
        }

        return listItems
    }
}
