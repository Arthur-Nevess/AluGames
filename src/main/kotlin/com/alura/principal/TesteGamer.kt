package com.alura.principal

import com.alura.Gamer.Gamer
import com.alura.servicos.ConsumoApi

fun main(){
    val jogador  = ConsumoApi()
    val caroline = jogador.consomeGamer().get(3)
    val jogo = ConsumoApi().ConsumoJogo("150")

    val aluguel = caroline.aluga(jogo)
    println(aluguel)

}