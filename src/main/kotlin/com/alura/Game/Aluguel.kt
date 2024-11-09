package com.alura.Game

import com.alura.Gamer.Gamer
import java.time.LocalDate
import java.time.Period

class Aluguel(
    val jogo: Game,
    val jogador: Gamer,
    val dataInicial: LocalDate,
    val dataFinal: LocalDate){
    val valorJogo = jogo.preco * Period.between(dataInicial, dataFinal).days
    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo}, feito por ${jogador.idInterno}, pelo valor de $valorJogo"
    }
}
