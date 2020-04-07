package id.ac.unhas.infocovid19.ui.kasus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class KasusViewModelFactory (
    private val repository: KasusRepository
):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(KasusRepository::class.java).newInstance(repository)
    }
}