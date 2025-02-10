package com.example.Assignment.controller;

import com.example.Assignment.model.Transaction;
import com.example.Assignment.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    // Calculate total reward points for each customer
    @PostMapping("/calculate")
    public Map<String, Integer> calculateRewardPoints(@RequestBody List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId,
                        Collectors.summingInt(rewardService::calculateRewardPoints)));
    }

    // Calculate monthly reward points for each customer
    @PostMapping("/monthly")
    public Map<String, Map<String, Integer>> calculateMonthlyRewardPoints(@RequestBody List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId,
                        Collectors.groupingBy(transaction -> transaction.getTransactionDate().substring(0, 7),
                                Collectors.summingInt(rewardService::calculateRewardPoints))));
    }
}
