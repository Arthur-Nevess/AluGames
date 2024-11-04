package com.alura.Utilitario

import com.alura.Gamer.Gamer
import com.alura.info.InfoGamerJson

fun InfoGamerJson.criagamer (): Gamer{
    return Gamer(this.nome, this.email,this.dataDeNascimento,this.usuario)
}