package com.alura.Game

import com.alura.Gamer.Gamer

class Aluguel(val jogo: Game, val jogador: Gamer ){
    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo}, feito por ${jogador.idInterno}"
    }
}
