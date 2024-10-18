package com.alura.info

import com.alura.Game.Game

data class InfoJogo (val info : InfoApiShark){
    override fun toString(): String {
        return info.toString()
    }
}