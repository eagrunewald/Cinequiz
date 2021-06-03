package com.example.cinequiz.search.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinequiz.catalog.Dados
import com.example.cinequiz.catalog.ErrorApi
import com.example.cinequiz.model.MovieData.MovieData
import com.example.cinequiz.repository.MoviesRepository
import com.example.cinequiz.search.model.ItemSearch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    val errorMessage: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val movies: MutableLiveData<MovieData> by lazy { MutableLiveData<MovieData>() }

    private val repository = MoviesRepository()

    init {
        moviesData()
    }


    private fun moviesData() = CoroutineScope(Dispatchers.IO).launch {
//        Dados.itemSearch.clear()
//        Dados.moviesFirebase.forEach { movieID ->
//                try {
//
//                        Dados.postMovieID(movieID)
//                        repository.getMovieData().let { moviesData ->
//                            movies.postValue(moviesData)
//                        }
//                    delay(300L)
//                        Dados.itemSearch.add(ItemSearch(movies.value?.backdropPath!!, movies.value?.title!!, movies.value!!.posterPath.toString()))
//
//
//
//                } catch (error: Throwable) {
//                    ErrorApi(error, errorMessage)
//                    Dados.itemSearch.add(ItemSearch("https://rockcontent.com/wp-content/uploads/2021/02/stage-en-error-1020.png", "Conteúdo indisponível", ""))
//                    Log.d("Erro", errorMessage.toString())
//                }
//            }
    }
}