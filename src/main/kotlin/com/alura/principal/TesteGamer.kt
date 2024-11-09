package com.alura.principal

import com.alura.Gamer.Gamer
import com.alura.servicos.ConsumoApi
import java.time.LocalDate

fun main(){
    val jogador  = ConsumoApi()
    val caroline = jogador.consomeGamer().get(3)
    val Dandara = jogador.ConsumoJogo().get(5)
    val alugando =  caroline.aluga(Dandara, LocalDate.now(), LocalDate.of(2024, 11, 19))
    println(alugando)
}