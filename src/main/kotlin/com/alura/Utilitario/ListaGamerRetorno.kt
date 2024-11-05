package com.alura.Utilitario

import com.alura.Gamer.Gamer
import com.alura.info.InfoGamerJson

fun InfoGamerJson.criaGamer (): Gamer{
    return Gamer(this.nome, this.email,this.dataNascimento,this.usuario)
}