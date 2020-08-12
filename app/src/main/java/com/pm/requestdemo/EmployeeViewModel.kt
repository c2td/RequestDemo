package com.pm.requestdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class EmployeeViewModel : ViewModel() {

    private val repository = Repository()

    val liveData : LiveData<List<Employee>> = repository.fetchContents()

    override fun onCleared() {
        super.onCleared()
        // cancel the request if ViewModel is destroyed
        repository.cancelRequest()
    }

}