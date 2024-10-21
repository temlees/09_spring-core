package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService {

    //객체들을 list형식으로 담기 때문에 모든 포켓몬이 공격을 하게 된다
    @Autowired
    private List<Pokemon> pokemonList;

    public void pokemonAttack(){
        for (Pokemon pokemon : pokemonList) {
            pokemon.attack();
        }
    }
}
