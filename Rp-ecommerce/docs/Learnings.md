# Backend Engineering Notes: System Design and Key Concepts

## 1. **Orchestrator Pattern**
- **What is it?**: A design pattern where a centralized service (`OrderOrchestratorService`) coordinates multiple services to ensure a consistent workflow.
- **Key Responsibilities**:
    - Delegates tasks to other services (e.g., `OrderService`, `PaymentService`, `StockService`).
    - Manages the overall workflow and ensures atomicity.
    - Handles rollback in case of failures.
- **Advantages**:
    - Centralized control of the workflow.
    - Simplifies error handling and rollback mechanisms.
    - Decouples individual services, making them reusable.
- **Best Practices**:
    - Keep the orchestrator lightweight; avoid adding too much business logic.
    - Log every step for better debugging and monitoring.
    - Use transactions to ensure atomicity when possible.

---

## 2. **Rollback Mechanism**
- **Why is it important?**: Ensures data consistency when a failure occurs during a multi-step process.
- **Example**:
    - If payment fails, rollback the reserved stock.
    - If stock reservation fails, cancel the order creation.
- **Implementation**:
    - Use compensating transactions to undo changes made by previous steps.
    - Ensure rollback logic is idempotent (can be safely retried).
- **Best Practices**:
    - Test rollback scenarios thoroughly.
    - Log rollback actions for debugging and auditing.
    - Handle partial rollbacks gracefully to avoid inconsistent states.

---

## 3. **Threading and Retry Mechanisms**
- **Thread.sleep**:
    - Used to introduce delays between retries.
    - Be cautious as it blocks the thread and can impact performance.
- **Exponential Backoff**:
    - A retry strategy where the delay increases exponentially after each failed attempt.
    - Example:
        - First retry: 2 seconds
        - Second retry: 4 seconds
        - Third retry: 8 seconds
- **Best Practices**:
    - Use libraries like `Resilience4j` or `Spring Retry` for production-grade retry mechanisms.
    - Always handle `InterruptedException` properly to avoid unexpected behavior.
    - Avoid blocking threads in high-concurrency environments; consider asynchronous retries.

---

## 4. **Transient Failure Scenarios**
- **What are they?**: Temporary failures that can be resolved by retrying the operation.
    - Examples: Network timeouts, database connection issues, or payment gateway unavailability.
- **Handling Transient Failures**:
    - Implement retry logic with a maximum retry limit.
    - Use exponential backoff to avoid overwhelming the failing service.
    - Log failures for monitoring and debugging.
- **Best Practices**:
    - Differentiate between transient and permanent failures.
    - Use circuit breakers to prevent cascading failures in the system.
    - Monitor retry attempts to identify recurring issues.

---