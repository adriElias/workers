# Java Annotations

Educational Java project to learn and practice built-in annotations (`@Override` and `@Deprecated`) in a real class hierarchy.

## Objective

- Use `@Override` to ensure correct method overriding
- Apply `@Deprecated` to mark obsolete code
- Suppress deprecation warnings with `@SuppressWarnings`
- Demonstrate polymorphism, inheritance and different salary calculation rules

## Exercises

### Exercise 1 – @Override
Create a worker hierarchy:

- `Worker` (base class):
    - Fields: name, surname, pricePerHour
    - Method: `calculateSalary(int hours)` → hours × pricePerHour

- `OnsiteWorker` (extends Worker):
    - Static field: fuelAllowance
    - Override salary: base + fuelAllowance
    - Use `@Override`

- `OnlineWorker` (extends Worker):
    - Static constant: internet flat rate
    - Override salary: base + internet rate
    - Use `@Override`

From `main()`: create instances and call `calculateSalary()` polymorphically.

### Exercise 2 – @Deprecated
- Add deprecated methods in child classes
- Mark them with `@Deprecated`
- Call them from `main()` while suppressing warnings using `@SuppressWarnings("deprecation")`

## Project Structure
```text
workerOverride/
├── pom.xml
└── src/
├── main/java/
│   └── Worker.java
│   └── OnlineWorker.java
│   └── OnsiteWorker.java
│   └── Main.java
└── test/java/
└── WorkerTest.java    
```
## How to Run

```bash
# Maven
mvn test
```
### Example Output
```text
Worker: Anna Smith - Salary: 1200.0 € (40 hours)

Onsite Worker: Carlos López - Salary: 1250.0 € (40 hours + fuel allowance)

Online Worker: Laura Martínez - Salary: 1300.0 € (40 hours + internet flat rate)

Calling deprecated method (warnings suppressed):
Old salary calculation: 1200 € (deprecated)
```

### Tests (JUnit 5 + AssertJ)
```Java
@Test
void onsiteSalaryIncludesFuel() {
OnsiteWorker onsiteWorker = new OnsiteWorker("Carlos", "López", 30);
double salary = onsiteWorker.calculateSalary(40);
assertThat(salary).isEqualTo(40 * 30 + OnsiteWorker.fuel);
}

@Test
void onlineSalaryIncludesInternetRate() {
OnlineWorker onlineWorker = new OnlineWorker("Laura", "Martínez", 32);
double salary = onlineWorker.calculateSalary(40);
assertThat(salary).isEqualTo(40 * 32 + OnlineWorker.INTERNET_RATE);
}

@Test
void shouldThrowExceptionOnInvalidHours() {
    Worker worker = new Worker("Test", "Test", 10);
    assertThrows(IllegalArgumentException.class, () -> worker.calculateSalary(-5));
}
```