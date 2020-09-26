package api

import api.client.buildClient
import api.model.BookingResult
import api.model.Centre
import api.model.Place

internal object CandilibApi {
    private val httpClient = buildClient(
        scheme = "http",
        appHost = "localhost:8000",
        apiPath = "api/v2",
        appJWTToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmNTc5M2FkOGJlODczNGQzMzJiYmY2NiIsImxldmVsIjowLCJpYXQiOjE1OTk5MzgxMzksImV4cCI6MTYwMDE5NzMzOX0.LmHzsntmJKsiPCQYNWz3zYRBM07nW9b6VLpibZRPewE"
    )

    // begin API endpoints

    suspend fun getCentres(depNumber: String): List<Centre>? =
        httpClient.get("candidat/centres", "departement" to depNumber)

    suspend fun getPlacesForCentre(centreId: String): List<String>? = httpClient.get("candidat/places/$centreId")

    suspend fun bookPlace(place: Place): BookingResult? = httpClient.patch("candidat/places", place)

    // end API endpoints
}