package com.alura.servicos

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers


class Servicos {
    var client: HttpClient = HttpClient.newHttpClient()

    var request: HttpRequest = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=612"))
        .build()
    var response: HttpResponse<String> = client
        .send(request, BodyHandlers.ofString())
    val json = response.body()
}