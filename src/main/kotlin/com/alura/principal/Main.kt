package com.alura.principal

import com.alura.Game.Game
import com.alura.Gamer
import com.alura.servicos.Servicos
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    Gamer.criaGamer(scanner)
    do {
        println("Digite o id do jogo que procura:")
        val id = scanner.nextLine()
        var meuJogo:Game? = null
        val resultado = runCatching {
            val dadosJogo = Servicos(id)
            meuJogo = Game(
                dadosJogo.meuJogo.info.title,
                dadosJogo.meuJogo.info.thumb)

        }

        resultado.onFailure {
            println("Id inválido")
        }

        resultado.onSuccess {
            println("Deseja adicinoar uma descrição em seu jogo? S/N")
            val resposta = scanner.nextLine()

            if (resposta.equals("S", true)){
                println("Insira a descrição que deseja adicinar")
                val descricaoUsuario = scanner.nextLine()
                meuJogo?.descricao = descricaoUsuario
            }
            else{
                meuJogo?.descricao = meuJogo?.titulo
            }
        }

        println(meuJogo)

        println("Deseja buscar mais algum jogo  S/N")
        val resposta = scanner.nextLine()

    }while(resposta.equals("S", true))

    println("Busca finalizada com sucesso!")
 }
