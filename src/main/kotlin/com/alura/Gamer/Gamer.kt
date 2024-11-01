package com.alura.Gamer

import com.alura.Game.Game
import java.util.Scanner
import kotlin.random.Random

data class Gamer(val nome:String, var  email:String ){
    var dataDeNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if(idInterno.isNullOrBlank()){
                geraIdInterno()
            }
        }
    var idInterno: String? = null
        private set

    val listaGames = mutableListOf<Game?>()
    constructor(nome: String, email: String, dataDeNascimento: String, usuario:String)
            : this(nome, email) {
        this.dataDeNascimento = dataDeNascimento
        this.usuario = usuario
        geraIdInterno()
    }

//    init {
//        if (nome.isNullOrBlank()){
//            throw IllegalArgumentException("Nome não pode estar em branco")
//        }
//        this.email = validaEmail()
//    }

    override fun toString(): String {
        val gamerString = """
            Dados do jogador:
            
              Nome: $nome
              Email: $email
              Data de nascimento: $dataDeNascimento
              Usuario: $usuario
              idInterno: $idInterno
              
        """.trimIndent()
        return gamerString
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

    companion object{
        fun criaGamer (scaner: Scanner) : Gamer {
            println("Bem vindos ao AluGames Vamos fazer seu cadastro!\n")
            println("Digite seu nome:")
            val nome = scaner.nextLine()
            println("Digite seu email:")
            val email = scaner.nextLine()
            println("Deseja fazer seu cadastro completo?  S/N")
            val resposta = scaner.nextLine()
            if(resposta.equals("s", true)){
                println("Digite sua data de nascimento:")
                val dataDeNascimento = scaner.nextLine()
                println("Digite seu nome de usuario:")
                val usuario = scaner.nextLine()
                return Gamer(nome, email, dataDeNascimento, usuario)
            }
            else{
                return Gamer(nome, email)
            }
        }
    }
}