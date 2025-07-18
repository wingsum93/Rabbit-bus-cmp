package org.ericho.recipeappcmp.data.remote

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


fun readResourceFile(path: String): String {
    return object {}.javaClass.classLoader
        .getResource(path)
        ?.readText() ?: error("File not found: $path")
}

fun createMockHttpClient(responseMap: Map<String, String>): HttpClient {
    val mockEngine = MockEngine { request ->
        val responseJson = responseMap[request.url.fullPath]
            ?: error("No mock response for ${request.url.fullPath}")

        respond(
            content = responseJson,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    return HttpClient(mockEngine) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
}
