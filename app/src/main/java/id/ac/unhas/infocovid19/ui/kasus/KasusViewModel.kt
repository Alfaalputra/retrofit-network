package id.ac.unhas.infocovid19.ui.kasus

import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.Kasus

class KasusViewModel(
    private val repository: KasusRepository
) : ViewModel() {
    private var _kasus = ArrayList<Kasus>()
    val kasus:ArrayList<Kasus>
        get() = _kasus

    fun getMoviesFromRepo(){
        //_movies.clear()
        _kasus.apply {
            if(isEmpty()){
                addAll(repository.getKasusFromJsonString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _kasus.clear()
    }
}
