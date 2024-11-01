package com.alura.servicos

import com.alura.Game.Game
import com.alura.info.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers


class ConsumoApi{
    fun ConsumoApifun( id: String): InfoJogo{
        var client: HttpClient = HttpClient.newHttpClient()
        var request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()
        var response: HttpResponse<String> = client
            .send(request, BodyHandlers.ofString())
        val json = response.body()
        val gson = Gson()
        val meuJogo = gson.fromJson(json, InfoJogo::class.java)
        return meuJogo
    }
}
