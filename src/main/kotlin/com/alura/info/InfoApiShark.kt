package com.alura.info

data class InfoApiShark (val title: String, val thumb: String){
    override fun toString(): String {
        return "Meu jogo\n" +
                "Titulo: $title\n" +
                "Capa: $thumb\n"
    }
}