# 🛒 QuantumShop – Modular E-Commerce System in Java

**QuantumShop** is a modular, object-oriented e-commerce simulation built with Java.  
The project is structured following the **MVC (Model-View-Controller)** pattern and emphasizes **Clean Code** and **SOLID principles**, especially the **Single Responsibility Principle**.

It simulates a small-scale shopping experience where:
- Customers can add different types of products to their cart
- Products may expire or require shipping
- A checkout service handles all core logic with validations, pricing, shipping, and receipt generation

---

## 📌 Key Features

✅ Define diverse products:  
- **Expirable**: Cheese, Biscuits (have an expiry date)  
- **Shippable**: TV, Cheese (have weight and need shipping)  
- **Digital**: Scratch cards (non-expirable & non-shippable)

✅ Functional Cart System:  
- Add items with quantity limit based on stock  
- Items are validated before checkout

✅ Checkout System:
- Subtotal calculation
- Shipping fees based on items
- Final amount calculation
- Balance deduction and cart clearance

✅ Shipment Handling:
- Collects only shippable items
- Calculates total weight
- Logs shipment notice

✅ Robust Validation and Exception Handling:
- Prevent checkout with expired items
- Handle insufficient balance
- Validate stock availability
- Catch and log checkout exceptions gracefully

✅ Console Output:
- Neatly formatted receipt and shipment logs using `Logger`

---

## 🧠 Design Principles Applied

### ✅ Single Responsibility Principle (SRP)
Each class has only **one reason to change**. Examples:

| Class/Service             | Responsibility                                             |
|--------------------------|------------------------------------------------------------|
| `Cart`                   | Handles item storage and operations inside the cart        |
| `CheckoutService`        | Manages the checkout logic only                            |
| `ValidationService`      | Handles all validations (cart empty, expired, stock, etc.) |
| `ShippingService`        | Manages shipping logic: item collection & weight calc.     |
| `PricingService`         | Handles subtotal and discount/stock reductions             |
| `ReceiptService`         | Generates the final receipt output                         |
| `CheckoutController`     | Controls the flow between view and service layer           |

> ✅ This improves **testability**, **maintainability**, and **scalability** of the codebase.

### ✅ Other Principles:
- **Open/Closed Principle** → You can extend product types without modifying base classes.
- **Liskov Substitution Principle** → `Cheese`, `TV`, `ScratchCard` can be used as `Product`.
- **Interface Segregation** → `Shippable`, `Expirable` are small, focused interfaces.
- **Dependency Inversion** → Services are injected and decoupled from implementations.


---

## 🧪 Testing

Unit tests are written using **JUnit 5**.

### ✅ Covered Scenarios:
- ✅ Successful checkout with valid products
- ❌ Checkout with expired products
- ❌ Checkout with insufficient balance
- ❌ Checkout with empty cart
- ✅ Assertions on cart clearance and balance after payment

Example:
```java
assertThrows(ProductExpireException.class, () -> {
    controller.handleCheckout(customer);
});
```

----
##  📦 Console Output Example
** Shipment notice **
Cheese
200g
Cheese
200g
Biscuits
700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese       200
1x Biscuits     150
1x ScratchCard   50
----------------------
Subtotal         400
Shipping          30
Amount            430
Remaining balance: 570

----

## 🔧 How to Run

1. Clone the repo:
```bash
git clone https://github.com/yusefellban/fawry-intern-task.git
cd QuantumShop
```

2. Compile and run:
```bash
javac Main.java
java Main
```

3. To run tests (with Maven):
```bash
mvn test
```

---

## 🛠️ Technologies Used

- Java 21+
- Maven
- JUnit 5 (Testing)
- Java Logging (Logger)
- Object-Oriented Programming
- MVC Architecture & SOLID Principles

---

## 🔮 Future Enhancements

- [ ] Add support for product discounts and coupons
- [ ] Connect to a relational database (JPA/Hibernate)
- [ ] Add Admin Panel for product management
- [ ] Build a RESTful API using Spring Boot
- [ ] Build a GUI using JavaFX or frontend with React
- [ ] Add role-based user management (admin vs customer)

---

## 👨‍💻 Author

**Yousef El-llban**  
_Java Full-Stack Developer_  
📍 Egypt  
🔗 [LinkedIn Profile](https://www.linkedin.com/in/youssef-ellban)

---


