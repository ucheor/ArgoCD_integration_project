# Restaurant Ordering System

A Java Spring Boot web application for restaurant menu ordering with receipt generation.

## Features

- **Menu with 11 Items**:
  - 2 Starters: Garlic Bread, Soup of the Day
  - 3 Main Courses: Grilled Chicken, Veggie Pasta, Beef Burger
  - 2 Desserts: Chocolate Cake, Ice Cream
  - 2 Drinks: Soft Drink, Coffee
  - 1 Seasonal Special: Chef's Seasonal Dish

- **Ordering Features**:
  - Select quantity (0-3) per item
  - Real-time quantity adjustment with +/- buttons
  - Automatic price calculation
  - Remove items by setting quantity to 0

- **Receipt Generation**:
  - Clean, printable receipt format
  - Shows item name, quantity, and line total
  - Calculates subtotal, tax (13%), and total
  - Printable receipt view

## Build and Run

### Using Docker

1. Build the Docker image:
```bash
docker build -t restaurant-ordering-app .
```

2. Run the container:
```bash
docker run -p 3100:3100 restaurant-ordering-app
```

3. Access the application:
```
http://localhost:3100
```

### Using Maven (without Docker)

1. Build the JAR file:
```bash
mvn clean package
```

2. Run the application:
```bash
java -jar target/restaurant-ordering-app.jar
```

## Application Structure

```
restaurant-ordering-app/
├── src/
│   └── main/
│       ├── java/com/restaurant/ordering/
│       │   ├── RestaurantOrderingApplication.java
│       │   ├── MenuItem.java
│       │   ├── OrderItem.java
│       │   ├── Receipt.java
│       │   ├── MenuService.java
│       │   └── OrderController.java
│       └── resources/
│           ├── templates/
│           │   └── menu.html
│           └── application.properties
├── Dockerfile
├── pom.xml
└── README.md
```

## API Endpoints

- `GET /` - Display menu and ordering interface
- `POST /order` - Process order and return receipt JSON

## Configuration

- **Port**: 3100 (configurable in `application.properties`)
- **Tax Rate**: 13% (configurable in `Receipt.java`)

## Technologies Used

- Java 17
- Spring Boot 3.2.0
- Thymeleaf
- Maven
- Docker