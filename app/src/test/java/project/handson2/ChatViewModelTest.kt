package project.handson2

import org.junit.Test
import org.junit.Assert.*

class ChatViewModelTest {

    @Test
    fun testAddUserMessage() {
        val viewModel = ChatViewModel()
        viewModel.addUserMessage("Hello")

        val messages = viewModel.messages.value
        assertNotNull(messages)
        assertEquals(1, messages?.size)
        assertEquals("Hello", messages?.get(0)?.content)
        assertTrue(messages?.get(0)?.isUser ?: false)
    }

    @Test
    fun testAddBotMessage() {
        val viewModel = ChatViewModel()
        viewModel.addBotMessage("Hi there!")

        val messages = viewModel.messages.value
        assertNotNull(messages)
        assertEquals(1, messages?.size)
        assertEquals("Hi there!", messages?.get(0)?.content)
        assertFalse(messages?.get(0)?.isUser ?: true)
    }
}