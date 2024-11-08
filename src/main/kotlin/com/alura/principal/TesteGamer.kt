package com.alura.principal

import com.alura.Gamer.Gamer
import com.alura.servicos.ConsumoApi

fun main(){
    val jogador  = ConsumoApi()
    val listaGamers = jogador.consomeGamer()

    val jogo = ConsumoApi().ConsumoJogo("150")

    println(jogo)
}