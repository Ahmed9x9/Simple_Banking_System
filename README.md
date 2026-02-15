# Simple Banking System

A Java-based banking simulation application that demonstrates object-oriented programming concepts including inheritance, encapsulation, and polymorphism.

## Features

### Manager
- View bank reports (transactions, deposits, withdrawals, loan statistics)
- View list of employees
- View list of customers
- Terminate employee accounts

### Employee
- Lock/Unlock customer accounts
- Make deposits for customers
- Make withdrawals for customers
- Process loan requests (approve/reject)

### Customer
- View balance
- Make deposits
- Make withdrawals
- Transfer money to other customers
- Request loans

## Project Structure

```
├── Account.java      # Base class for all account types
├── Manager.java      # Manager class with administrative features
├── Employee.java     # Employee class with customer management features
├── Customer.java     # Customer class with banking operations
└── Main.java         # Main application with CLI interface
```

## How to Run

### Compile
```bash
javac *.java
```

### Run
```bash
java Main
```

## Class Hierarchy

```
Account (Base Class)
├── Manager
├── Employee
└── Customer
```

## Error Handling

The application includes comprehensive error handling:
- Input validation for all numeric entries
- Empty list checks before login attempts
- Invalid selection handling with user-friendly messages
- Account status verification for transactions

## Author

Ahmed

## License

This project is for educational purposes.
