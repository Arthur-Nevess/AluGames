package com.alura.Aluguel

import com.alura.Game.Game
import com.alura.Gamer.Gamer

class Aluguel(
    val jogo: Game,
    val jogador: Gamer,
    val periodo: calculaPeriodo
    ){
    val valorJogo = jogador.plano.calcula(this)
    var preco = String.format("%.2f", valorJogo).replace(Regex("\\.?0+$"), "")
    override fun toString(): String {
        return "\nAluguel do jogo ${jogo.titulo}, feito por ${jogador.idInterno}, pelo valor de $preco\n"
    }
}
