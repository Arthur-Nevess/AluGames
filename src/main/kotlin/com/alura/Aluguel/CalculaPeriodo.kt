package com.alura.Aluguel

import java.time.LocalDate
import java.time.Period

class calculaPeriodo(val dataInicial: LocalDate,
                     val dataFinal: LocalDate) {
    val emDias = Period.between(dataInicial, dataFinal).days
}