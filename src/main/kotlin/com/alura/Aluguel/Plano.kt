package com.alura.Aluguel

abstract class Plano(tipo: String){
   open fun calcula (aluguel: Aluguel):Double{
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }

}