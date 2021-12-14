package com.example.demo.database;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class); // get class Database vao logger

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
//            Product productA = new Product("iphone 4s","Apple","Made in Viet Nam",3000,"");
//            Product productB = new Product("iphone 5", "Apple", "Made in Viet Nam", 2000, "");
//            logger.info("insert into " + productRepository.save(productA));
//            logger.info("insert into " + productRepository.save(productB));

        };
    }

}
