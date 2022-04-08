package com.example.pokecopia.domain.repository

import com.example.pokecopia.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonList(): Flow<List<Pokemon>>
}