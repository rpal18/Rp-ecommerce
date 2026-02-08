# 📝 Learning Log: Resolving JPA Detached Entity Errors

## 1. The Error
While implementing the `DataLoader` to seed the database, the application crashed with the following exception:

**Error:** `org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist: com.ecommerce.Rp_ecommerce.model.Role`

## 2. Technical Context
* **Entity:** `Role` (with `GenerationType.IDENTITY`)
* **Relationship:** A `User` has a `Set<Role>`.
* **Action:** Saving a `Role`, then assigning it to a `User` and saving the `User`.

## 3. What Happened? (The "Why")
Hibernate manages entities using a **Persistence Context** (a first-level cache). Entities move through different states:



### The Problematic Flow:
1. **Save Role:** `roleRepository.save(userRole)` was called. Without a transaction, the session opened, saved the role, and **closed immediately**.
2. **State Change:** Once the session closed, the `userRole` object became **Detached**. It had an ID, but Hibernate was no longer tracking it.
3. **Save User:** When `userRepository.save(user)` was called, a **new session** opened.
4. **The Conflict:** Hibernate looked at the `userRole` inside the User. Because it had an ID, Hibernate assumed it was a detached object. Since the mapping likely used `CascadeType.PERSIST` or `ALL`, Hibernate tried to "create" it again. Hibernate cannot "persist" an object that already has an ID, leading to the crash.

## 4. The Solution: `@Transactional`
I added the `@Transactional` annotation to the `run` method in the `DataLoader` class.

```java
@Override
@Transactional
public void run(String... args) {
    // 1. Save/Fetch Role
    // 2. Assign to User
    // 3. Save User
}