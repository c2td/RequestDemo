package com.pm.requestdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pm.requestdemo.data.Movie
import com.pm.requestdemo.data.Repository

class MovieViewModel : ViewModel() {

    private val repository = Repository()

    val liveData : LiveData<List<Movie>> = repository.fetchContents()

    override fun onCleared() {
        super.onCleared()
        // cancel the request if ViewModel is destroyed
        repository.cancelRequest()
    }

}