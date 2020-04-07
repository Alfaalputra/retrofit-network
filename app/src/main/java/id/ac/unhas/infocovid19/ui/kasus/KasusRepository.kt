package id.ac.unhas.infocovid19.ui.kasus

import id.ac.unhas.infocovid19.model.DataKasus
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.Kasus

class KasusRepository(
    private val jsonString: String
) {
    fun getKasusFromJsonString() : ArrayList<Kasus>{
        val listKasus = ArrayList<Kasus>()
        val dataKasus: DataKasus = DataSource.createDataSetKasus(jsonString)
        dataKasus.data?.forEach {
            if (it != null) {
                listKasus.add(it)
            }
        }
        return listKasus
    }
}
