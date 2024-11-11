package com.alura.principal

import com.alura.Game.calculaPeriodo
import com.alura.Gamer.Gamer
import com.alura.servicos.ConsumoApi
import java.time.LocalDate

fun main(){
    val jogador  = ConsumoApi()
    val caroline = jogador.consomeGamer().get(3)
    val Dandara = jogador.ConsumoJogo().get(5)
    val jogo2 = jogador.ConsumoJogo().get(6)
    val jogo3 = jogador.ConsumoJogo().get(7)
    val jogo4 = jogador.ConsumoJogo().get(8)

     val periodo = calculaPeriodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = calculaPeriodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo3 = calculaPeriodo(LocalDate.now(), LocalDate.now().plusDays(8))
    val periodo4 = calculaPeriodo(LocalDate.now(), LocalDate.now().plusDays(5))


    val alugando =  caroline.aluga(Dandara,periodo)
    val alugando2 = caroline.aluga(jogo2,periodo2)
    val alugando3 = caroline.aluga(jogo3,periodo3)
    val alugando4 = caroline.aluga(jogo4,periodo4)
    println(caroline.listaAluguel)
}