package com.okcupid.assessment

import com.okcupid.assessment.entities.PetItem
import com.okcupid.assessment.util.cloneList
import org.junit.Test

import org.junit.Assert.*

/**
 * Contains unit tests for util functions
 */
class UtilityTest {
    /**
     * Test [cloneList] extension function
     */
    @Test
    fun checkClonedPetList() {
        val empty = listOf<PetItem>()
        val data = listOf(
            PetItem("1", "John", 20, "US", "CA", "Fresno", "some_img1", 10, true),
            PetItem("2", "Andrew", 25, "US", "MN", "Minneapolis", "some_img2", 20, false)
        )
        assertEquals(empty, empty.cloneList())
        assertEquals(data, data.cloneList())
    }
}