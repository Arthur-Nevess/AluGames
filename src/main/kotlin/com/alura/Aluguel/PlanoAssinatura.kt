package com.alura.Aluguel

import com.alura.Gamer.Gamer

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val limiteDeJogos: Int): Plano(tipo)
{
    override fun calcula(aluguel: Aluguel): Double {
        val jogador: Gamer = aluguel.jogador
        val quantidadeDejogos = jogador.listaAluguel.size

        if(quantidadeDejogos <= 2){
            aluguel.preco = "0.00"
            return 0.00
        }
        else{
            return aluguel.jogo.preco * aluguel.periodo.emDias
        }
    }
}