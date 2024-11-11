package com.alura.Game

import com.alura.info.InfoApiShark

data class Game (    val titulo:String,
                     val capa:String,
                     val preco:Double
) {
    var descricao:String? = null

    override fun toString(): String {
        return "Meu jogo:\n" +
                "Titulo: $titulo\n" +
                "Capa: $capa\n" +
                "Descricao: $descricao\n" +
                "Preço: $preco\n"


    }
}