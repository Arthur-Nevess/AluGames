package com.alura.principal

import com.alura.Gamer

fun main() {
    val gamer = Gamer("Arthur", "arthur@gmail.com")

    val gamer2 = Gamer(
        "Lolô",
        "empadasdalo@gmail.com",
        "22/04/2021",
        "Empada de Nutella")

    gamer.let {
        it.usuario = "Tutuzin"
        it.dataDeNascimento = "16/03/2003"
    }

    println(gamer)
    println(gamer2)
}