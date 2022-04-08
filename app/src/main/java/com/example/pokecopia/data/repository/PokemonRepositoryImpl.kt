package com.example.pokecopia.data.repository

import com.example.pokecopia.domain.model.Pokemon
import com.example.pokecopia.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(

) : PokemonRepository {
    override fun getPokemonList(): Flow<List<Pokemon>> {
        return flow {
            emit(
                listOf(
                    Pokemon("Pikachu"),
                    Pokemon("Bulbassauro"),
                    Pokemon("Charmander"),
                    Pokemon("Snorlax"),
                )
            )
        }
    }
}