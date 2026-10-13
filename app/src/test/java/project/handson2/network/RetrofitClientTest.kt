package project.handson2.network

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RetrofitClientTest {

    @Test
    fun normalizeBaseUrl_mapsLocalhostToEmulatorHost() {
        assertEquals(
            "http://10.0.2.2:5000/",
            RetrofitClient.normalizeBaseUrl("http://127.0.0.1:5000")
        )
    }

    @Test
    fun normalizeBaseUrl_addsTrailingSlash() {
        assertEquals(
            "http://10.0.2.2:5000/",
            RetrofitClient.normalizeBaseUrl("http://localhost:5000")
        )
    }

    @Test
    fun normalizeBaseUrl_usesDefaultWhenBlank() {
        val normalized = RetrofitClient.normalizeBaseUrl("")
        assertTrue(normalized.startsWith("http://10.0.2.2:5000"))
    }
}
