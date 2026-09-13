package com.embarrasdf.testing

import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MainDispatcherExtension::class)
class MainDispatcherExtensionTest {

    @Test
    fun `test coroutine with Main dispatcher`() = runTest {
        var result = ""

        launch(Dispatchers.Main) {
            result = "Hello from Main dispatcher"
        }

        assertEquals("Hello from Main dispatcher", result)
    }

    @Test
    fun `test multiple coroutines on Main dispatcher`() = runTest {
        val results = mutableListOf<String>()

        launch(Dispatchers.Main) {
            results.add("First")
        }

        launch(Dispatchers.Main) {
            results.add("Second")
        }

        assertEquals(listOf("First", "Second"), results)
    }
}
