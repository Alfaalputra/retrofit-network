package id.ac.unhas.infocovid19.ui.harian

import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.Harian

class HarianViewModel(
    private val repository: HarianRepository
) : ViewModel() {
    private var _harian = ArrayList<Harian>()
    val harian:ArrayList<Harian>
        get() = _harian

    fun getMoviesFromRepo(){
        //_movies.clear()
        _harian.apply {
            if(isEmpty()){
                addAll(repository.getHarianFromJsonString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _harian.clear()
    }
}
