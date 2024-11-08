package com.alura.servicos

import com.alura.Gamer.Gamer
import com.alura.Utilitario.criaGamer
import com.alura.info.InfoGamerJson
import com.alura.info.InfoJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers


class ConsumoApi{
    fun consomeApi (endereco:String): String{
        var client: HttpClient = HttpClient.newHttpClient()
        var request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        var response: HttpResponse<String> = client
            .send(request, BodyHandlers.ofString())
        return response.body()

    }

    fun ConsumoJogo( id: String): InfoJogo{
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeApi(endereco)
        val gson = Gson()
        val meuJogo = gson.fromJson(json, InfoJogo::class.java)
        return meuJogo
    }

    fun consomeGamer(): List<Gamer>{
        val endereco ="https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeApi(endereco)
        val gson = Gson()
        val meuGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer:List <InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerOrdenada = listaGamer.map { InfoGamerJson -> InfoGamerJson.criaGamer() }
        return listaGamerOrdenada
    }
}
