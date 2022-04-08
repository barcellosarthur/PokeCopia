package com.example.pokecopia.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokecopia.domain.model.Pokemon
import com.example.pokecopia.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class MainViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase = GetPokemonListUseCase()
) : ViewModel() {

    private val pokemonListData = MutableLiveData<List<Pokemon>>()

    val pokemonList: LiveData<List<Pokemon>> = pokemonListData

    init {
        getPokemonList()
    }


    private fun getPokemonList() = viewModelScope.launch {
        getPokemonListUseCase()
            .flowOn(Dispatchers.IO)
            .collect { pokemons ->
                pokemonListData.value = pokemons
            }
    }
}