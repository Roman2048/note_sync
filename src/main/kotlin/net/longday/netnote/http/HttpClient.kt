package net.longday.netnote.http

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

object HttpClient {

    private val okHttpClient = OkHttpClient()

    private const val url = "http://localhost:8080/testapi"
//    private val url = "https://longday.net/netnote/api"

    fun send(body: String) {
        println("sending data")
        val request = Request.Builder()
            .url(url)
            .post(body.toRequestBody("text/plain; charset=utf-8".toMediaType()))
            .build()
        okHttpClient.newCall(request).execute()
    }
}