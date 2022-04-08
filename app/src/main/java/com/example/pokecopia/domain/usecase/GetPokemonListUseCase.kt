package com.example.pokecopia.domain.usecase

import com.example.pokecopia.data.repository.PokemonRepositoryImpl
import com.example.pokecopia.domain.model.Pokemon
import com.example.pokecopia.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonListUseCase(
    private val pokemonRepository: PokemonRepository = PokemonRepositoryImpl()
) {
    operator fun invoke(): Flow<List<Pokemon>> =
        pokemonRepository.getPokemonList()
}