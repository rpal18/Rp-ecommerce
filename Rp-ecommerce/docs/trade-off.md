# E-commerce Project – Design Decisions (Living Document)

This document records important design decisions taken during development.
It will be updated continuously as new features are implemented.

---

## 1. Purpose

* Keep track of design decisions
* Help in revision before interviews
* Maintain consistency in architecture
* Avoid repeating mistakes

---

## 2. General Principles

* Prefer simplicity over over-engineering
* Backend should control critical logic (price, payment, security)
* Do not expose entities directly
* Use DTOs for communication
* Use IDs instead of passing full objects

---

## 3. Order & Address Design

### Decision

Use `addressId` in request and store address snapshot inside Order.

### Reason

* Keeps request payload small
* Order remains independent of Address changes
* Ensures historical correctness

### Implementation Notes

* Fetch address using addressId
* Copy fields into Order entity
* Validate that address belongs to the user

---

## 4. Payment Design

### Decision

* Do not create a full PaymentRequestDTO
* Use PaymentResponseDTO
* Optional minimal DTO for payment method selection

### Reason

* Payment data should not come from frontend
* Gateway is source of truth

---

## 5. Order-Payment Relationship

### Decision

One Order can have multiple Payments

### Reason

* Supports retry on failure
* Keeps payment history

---

## 6. Price Handling

### Decision

Backend calculates all pricing

### Reason

* Prevents manipulation
* Ensures consistency

---

## 7. Order Immutability

### Decision

Orders should not change based on Address updates or deletion

### Reason

* Orders are business records
* Required for audit/history

---

## 8. API Flow

### Current Flow

1. Create Order
2. Reserve stock
3. Initiate payment
4. Update order on payment result

---

## 9. Security Considerations

* Validate ownership of address
* Validate product existence
* Validate stock availability

---

## 10. Performance Considerations

* Use LAZY loading where appropriate
* Avoid N+1 queries
* Use DTO mapping

---

## 11. Open Questions / Future Decisions


---

