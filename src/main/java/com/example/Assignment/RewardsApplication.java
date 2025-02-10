package com.example.Assignment;

import com.example.Assignment.model.Transaction;
import com.example.Assignment.service.RewardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RewardsApplication {

    @Autowired
    private RewardService rewardService; // Inject RewardService

    public static void main(String[] args) {
        SpringApplication.run(RewardsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            List<Transaction> transactions = Arrays.asList(
                    new Transaction("C1", 120, "2025-01-15"),
                    new Transaction("C1", 80, "2025-01-22"),
                    new Transaction("C2", 200, "2025-01-30"),
                    new Transaction("C1", 55, "2025-02-12"),
                    new Transaction("C3", 90, "2025-02-17"),
                    new Transaction("C2", 110, "2025-03-04")
            );

            // Testing Reward Calculation
            transactions.forEach(transaction -> {
                int points = rewardService.calculateRewardPoints(transaction); // Use the injected RewardService
                System.out.println("Transaction: " + transaction.getCustomerId() + ", Points: " + points);
            });
        };
    }
}
