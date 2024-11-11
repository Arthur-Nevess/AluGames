package com.alura.Game

import com.alura.Gamer.Gamer
import java.time.LocalDate
import java.time.Period

class Aluguel(
    val jogo: Game,
    val jogador: Gamer,
    val periodo: calculaPeriodo
    ){
    val valorJogo = jogo.preco * periodo.emDias
    val preco = String.format("%2f", valorJogo).replace(Regex("\\.?0+$"), "")
    override fun toString(): String {
        return "\nAluguel do jogo ${jogo.titulo}, feito por ${jogador.idInterno}, pelo valor de $preco\n"
    }
}
