package com.endurance.datajdbc.jdbc.RetailItem;

import com.endurance.datajdbc.repository.RetailItem.RetailItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class RetailItemTest {

    private final RetailItemRepository retailItemRepository;

    @Autowired
    public RetailItemTest(RetailItemRepository repository) {
        retailItemRepository = repository;
    }

    @Test
    public void createRetailItem() {
        RetailItem retailItem = RetailItem.of("Apple MacBookPro", "Apple Laptop", 2000);
        RetailItem persistedRetailItem = retailItemRepository.save(retailItem);
        assertNotNull(persistedRetailItem.getId(), ()->"New Retail Item not created.");
    }

    @Test
    public void deleteRetailItem() {
        RetailItem retailItem = RetailItem.of("Apple MacBookPro", "Apple Laptop", 2000);
        RetailItem persistedRetailItem = retailItemRepository.save(retailItem);
        retailItemRepository.deleteById(persistedRetailItem.getId());
        final Optional<RetailItem> retailItemOptional = retailItemRepository.findById(persistedRetailItem.getId());
        assertTrue(retailItemOptional.isEmpty(), ()->"Failed to delete retail item");
    }

}