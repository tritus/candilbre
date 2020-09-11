package api.client

internal expect class CandilibreClient {
    suspend inline fun <reified ExpectedResponse> get(
        endpoint: String,
        vararg urlParams: Pair<String, String>
    ): ExpectedResponse?

    suspend inline fun <reified ExpectedResponse, reified Body : Any> patch(
        endpoint: String,
        requestBody: Body
    ): ExpectedResponse?
}