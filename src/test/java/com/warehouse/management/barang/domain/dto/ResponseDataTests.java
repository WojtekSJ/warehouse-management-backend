package com.warehouse.management.barang.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseDataTests {
    private ResponseData<String> responseData;

    @BeforeEach
    void setUp() {
        responseData = new ResponseData<>(true, new ArrayList<>(), "test payload");
    }

    @Test
    void testGetters() {
        // GIVEN - A ResponseData object is created
        // WHEN - Getters are called on the object
        // THEN - The returned values match the expected values
        assertTrue(responseData.isStatus());
        assertEquals("test payload", responseData.getPayload());
        assertEquals(0, responseData.getMessages().size());
    }
}