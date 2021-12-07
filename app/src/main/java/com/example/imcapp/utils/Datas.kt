package com.example.imcapp.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun dataAtualBrasil(): String{
    // ** Obter a data atual, ou seja hoje!!

        val hoje = LocalDate.now()

    // ** Determinar o formato da data... brasileiro!!!
        val formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    // ** Converter a data para Brasil
        val hojeBrasil = hoje.format(formatoBrasil)

    return hojeBrasil
}