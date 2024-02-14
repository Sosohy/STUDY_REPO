package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /* 설명
     *  @Qualifier를 통해 원하는 bean의 이름(id)로 하나의 빈을 주입 받을 수 있다.
     *  (@Primary보다 우선순위가 높다.)
    * */
//    @Autowired
//    @Qualifier("squirtle")    // primary 무시하고 해당 포켓몬으로 주입
    private Pokemon pokemon;

    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
