package com.alura

data class Gamer(val nome:String, val email:String ){
    var dataDeNascimento: String? = null
    var usuario: String? = null
    val idInterno: String? = null

    constructor(nome: String, email: String, dataDeNascimento: String, usuario:String)
            : this(nome, email) {
        this.dataDeNascimento = dataDeNascimento
        this.usuario = usuario
    }

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
}
