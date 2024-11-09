package com.alura.principal

import com.alura.Game.Game
import com.alura.Gamer.Gamer
import com.alura.servicos.ConsumoApi
import transformaIdade
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val gamer = Gamer.criaGamer(scanner)
    println("Cadastro concluido com sucesso! Dados do gamer:")
    println(gamer)
    println("Você tem " + gamer.dataNascimento?.transformaIdade() + "anos")
    do {
        println("Digite o id do jogo que procura:")
        val id = scanner.nextLine()
        var meuJogo:Game? = null
        val resultado = runCatching {
            val dadosJogo = ConsumoApi().ConsumoJogo(id)
            meuJogo = Game(
                dadosJogo.titulo,
                dadosJogo.capa)

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

        resultado.onSuccess {
            gamer.listaGames.add(meuJogo)
        }
        println("Deseja buscar mais algum jogo  S/N")
        val resposta = scanner.nextLine()

    }while(resposta.equals("S", true))

    println("Busca finalizada com sucesso!")


    println("Jogos ordenado por titulo:")

    val titulos = gamer.listaGames.sortBy {
        it?.titulo
    }
    var i = 1
    gamer.listaGames.forEach {
        println("$i- Titulo: ${it?.titulo} ")
        i++
    }

    do {

        println("Deseja remover algum jogo da lista?  S/N")
        val remocao = scanner.nextLine()
        if (remocao.equals("S", true)) {
            println("Digite o número do jogo que deseja remover:")
            val numero = scanner.nextInt()
            gamer.listaGames.removeAt((numero - 1))
        }
        var j = 1
        gamer.listaGames.forEach {
            println("$j- Titulo: ${it?.titulo} ")
            j++
        }
        scanner.nextLine()
    }while(remocao.equals("S", true))
}

