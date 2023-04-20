package com.example.classapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classapp.data.model.BirdAPIResponse
import com.example.classapp.data.repository.BirdRepository
import com.example.classapp.model.Bird
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BirdViewModel @Inject constructor(
    private val birdRepository: BirdRepository,
) : ViewModel() {
    private var birdList: List<Bird> = emptyList()
    private val _birds = MutableStateFlow<BirdEvent>(BirdEvent.Loading)
    val birds = _birds.asStateFlow()

    fun fillData() = viewModelScope.launch {
        when (val response = birdRepository.getBirds(30)) {
            is BirdAPIResponse.Error -> _birds.value = BirdEvent.Failure
            is BirdAPIResponse.Success -> {
                for (i in 0 until response.birds.size) {
                    response.birds[i].id = i
                }
                _birds.value = BirdEvent.Success(response.birds)
                birdList = response.birds
            }
        }

    }

    sealed class BirdEvent {
        data class Success(val birds: List<Bird>) : BirdEvent()
        object Failure : BirdEvent()
        object Loading : BirdEvent()
    }

    fun getBirdById(id: Int) = birdList.first { it.id == id }


}
