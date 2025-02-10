# Help

## Calculate Total Reward Points
To calculate the total reward points for each customer:

```bash
curl -X POST http://localhost:8080/api/rewards/calculate \
-H "Content-Type: application/json" \
-d '[{"customerId": "C1", "amount": 120, "transactionDate": "2025-01-15"},
     {"customerId": "C1", "amount": 80, "transactionDate": "2025-01-22"},
     {"customerId": "C2", "amount": 200, "transactionDate": "2025-01-30"},
     {"customerId": "C1", "amount": 55, "transactionDate": "2025-02-12"},
     {"customerId": "C3", "amount": 90, "transactionDate": "2025-02-17"},
     {"customerId": "C2", "amount": 110, "transactionDate": "2025-03-04"}]'

curl -X POST http://localhost:8080/api/rewards/monthly \
-H "Content-Type: application/json" \
-d '[{"customerId": "C1", "amount": 120, "transactionDate": "2025-01-15"},
     {"customerId": "C1", "amount": 80, "transactionDate": "2025-01-22"},
     {"customerId": "C2", "amount": 200, "transactionDate": "2025-01-30"},
     {"customerId": "C1", "amount": 55, "transactionDate": "2025-02-12"},
     {"customerId": "C3", "amount": 90, "transactionDate": "2025-02-17"},
     {"customerId": "C2", "amount": 110, "transactionDate": "2025-03-04"}]'

