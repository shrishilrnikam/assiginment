package com.example.Assignment.service;

import com.example.Assignment.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    public int calculateRewardPoints(Transaction transaction) {
        int points = 0;
        int amount = transaction.getAmount();

        // Points for amount greater than 100
        if (amount > 100) {
            points += (amount - 100) * 2; // 2 points for every dollar above 100
            amount = 100; // Adjust remaining amount for next tier
        }

        // Points for amount between 50 and 100
        if (amount > 50) {
            points += (amount - 50); // 1 point for every dollar between 50 and 100
        }

        return points;
    }

}
