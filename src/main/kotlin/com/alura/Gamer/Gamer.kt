package com.alura.Gamer

import com.alura.Aluguel.Aluguel
import com.alura.Aluguel.Plano
import com.alura.Aluguel.PlanoAvulso
import com.alura.Game.Game
import com.alura.Aluguel.calculaPeriodo
import java.util.Scanner
import kotlin.random.Random

data class Gamer(val nome:String, var  email:String ){
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if(idInterno.isNullOrBlank()){
                geraIdInterno()
            }
        }
    var idInterno: String? = null
        private set
    var plano:Plano = PlanoAvulso("Bronze")
    val listaGames = mutableListOf<Game?>()
    val listaAluguel = mutableListOf<Aluguel?>()

    constructor(nome: String, email: String, dataDeNascimento: String, usuario:String)
            : this(nome, email) {
        this.dataNascimento = dataDeNascimento
        this.usuario = usuario
        geraIdInterno()
    }

   init {
        if (nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome não pode estar em branco")
        }
        this.email = validaEmail()
    }

    override fun toString(): String {
        val gamerString = """
            Dados do jogador:
            
              Nome: $nome
              Email: $email
              Data de nascimento: $dataNascimento
              Usuario: $usuario
              idInterno: $idInterno
              
        """.trimIndent()
        return gamerString
    }

    fun aluga (jogo: Game,periodo: calculaPeriodo): Aluguel {
        val aluguel = Aluguel(jogo, this, periodo)
        listaAluguel.add(aluguel)
        return aluguel
    }

    fun geraIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)
        idInterno = "$usuario#$tag"
    }

    fun validaEmail(): String{
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        if(emailRegex.matches(email)){
            return email
        }
        else{
            throw IllegalArgumentException("Email invalido")

        }
    }

    companion object {
        //USADO NOS PRIMEIROS PASSOS DO PROJERTO, ESTOU USANDO UMA API PARA CRIAR GAMER
        //ENTÃO FAZ-SE DESNECESSARIO
        fun criaGamer(scaner: Scanner): Gamer {
            println("Bem vindos ao AluGames Vamos fazer seu cadastro!\n")
            println("Digite seu nome:")
            val nome = scaner.nextLine()
            println("Digite seu email:")
            val email = scaner.nextLine()
            println("Deseja fazer seu cadastro completo?  S/N")
            val resposta = scaner.nextLine()
            if (resposta.equals("s", true)) {
                println("Digite sua data de nascimento:")
                val dataDeNascimento = scaner.nextLine()
                println("Digite seu nome de usuario:")
                val usuario = scaner.nextLine()
                return Gamer(nome, email, dataDeNascimento, usuario)
            } else {
                return Gamer(nome, email)
            }

        }
    }
}