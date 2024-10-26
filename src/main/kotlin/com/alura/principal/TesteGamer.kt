package com.alura.principal

import com.alura.Gamer

fun main(){
    val gamer1 = Gamer(
        "Alex",
        "alex@gmail.com")

    val gamer2 = Gamer(
        "Arthur",
        "arthur@gmail.com")

    gamer2.let {
        it.dataDeNascimento = "16/03/2003"
        it.usuario = "tutuzim"
    }.also {
        println(gamer2.idInterno)
    }

    println(gamer1)
    println(gamer2)
}