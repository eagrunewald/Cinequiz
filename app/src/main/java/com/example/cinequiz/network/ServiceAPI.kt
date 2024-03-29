package com.example.cinequiz.network

import com.example.cinequiz.model.MovieCredits.MovieCredits
import com.example.cinequiz.model.MovieData.MovieData
import com.example.cinequiz.model.SeriesCredits.SeriesCredits
import com.example.cinequiz.model.discoverMovies.MoviesByGenre
import com.example.cinequiz.model.discoverSeries.SeriesByGenre
import com.example.cinequiz.model.popularMovieModel.PopularMovies
import com.example.cinequiz.model.popularSeriesModel.PopularSeries
import com.example.cinequiz.model.quizModel.Quiz
import com.example.cinequiz.model.searchModel.Search
import com.example.cinequiz.model.searchModelSeries.SearchSeries
import com.example.cinequiz.model.tv.TvID


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

    @GET("api.php?amount=10")
    suspend fun getQuizQuestions(
        @Query("category") category: Int = 11,
        @Query("type") type: String = "multiple"
    ) : Quiz

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "pt-BR",
        @Query("page") page: Int
    ) : PopularMovies

    @GET("discover/movie")
    suspend fun getDiscoverMovies(
        @Query("language") language: String = "pt-BR",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("page") page: Int,
        @Query("with_genres") withGenre: String
    ): MoviesByGenre

    @GET("movie/{movie_id}/credits")
    suspend fun getActors(
        @Path("movie_id") movieID : Int,
        @Query("language") language: String = "pt-BR"
    ) : MovieCredits

    @GET("movie/{movie_id}")
    suspend fun getMovieData(
        @Path("movie_id") movieID : Int,
        @Query("language") language: String = "pt-BR"
    ) : MovieData

    @GET("search/multi")
    suspend fun search(
        @Query("language") language: String = "pt-BR",
        @Query("query") search:String,
        @Query("page") page: Int
    ) : Search

    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Query("language") language: String = "pt-BR",
        @Query("page") page: Int
    ) : PopularSeries

    @GET("discover/tv")
    suspend fun getDiscoverSeries(
        @Query("language") language: String = "pt-BR",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("page") page: Int,
        @Query("with_genres") withGenre: String
    ): SeriesByGenre

//    Ver com o Paulo
    @GET("tv/{tv_id}/credits")
    suspend fun getSeriesActors(
        @Path("tv_id") movieID : Int,
        @Query("language") language: String = "pt-BR"
    ) : SeriesCredits

    @GET("tv/{tv_id}")
    suspend fun getSeries(
        @Path("tv_id") tvID : Int,
        @Query("language") language: String = "pt-BR"
    ) : TvID

    @GET("search/multi")
    suspend fun searchSeries(
        @Query("language") language: String = "pt-BR",
        @Query("query") search:String,
        @Query("page") page: Int
    ) : SearchSeries

}