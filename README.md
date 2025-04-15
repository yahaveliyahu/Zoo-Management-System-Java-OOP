
# 🦁 Zoo Management System - Java OOP

A Java-based application that demonstrates Object-Oriented Programming (OOP) concepts through the simulation and management of a zoo.

## 📚 Overview

This project allows you to:

- Add and manage different types of animals
- Sort animals by custom logic (e.g., name, age)
- Represent different species using inheritance and polymorphism
- Apply comparators and interfaces for sorting and filtering
- Use exception handling and encapsulation
- Demonstrate team collaboration in a single Java project

## 🧠 Object-Oriented Design

- **Inheritance**:
  - `Predator` ← `Lion`, `Tiger`
  - `AquariumFish` ← `SimpleFish`, `ClownFish`, `GoldFish`
- **Composition**: `ZooManager` manages all animals (stored as `Object[]`)
- **Interface**: `Penguin` implements `Comparable<Penguin>`

## 🧱 Project Structure

```
ZooManager.java           // Main control logic
Main.java                 // Entry point
AquariumFish.java         // Base class for fish
├── SimpleFish.java
├── ClownFish.java
├── GoldFish.java
Predator.java             // Base class for predators
├── Lion.java
├── Tiger.java
Penguin.java              // Implements Comparable
PenguinNameComparator.java
PenguinAgeComparator.java
Address.java
```

## 📷 Class Diagram

![Class Diagram](https://github.com//yahaveliyahu-Zoo-Management-System-Java-OOP/assets/123456789/class_diagram.png)

