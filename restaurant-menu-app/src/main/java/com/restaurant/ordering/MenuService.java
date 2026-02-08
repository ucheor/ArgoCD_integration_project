package com.restaurant.ordering;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    private List<MenuItem> menu;

    public MenuService() {
        menu = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // Starters (2)
        menu.add(new MenuItem("Garlic Bread", 5.00, "Starters"));
        menu.add(new MenuItem("Soup of the Day", 6.50, "Starters"));

        // Main Courses (3)
        menu.add(new MenuItem("Grilled Chicken", 15.00, "Main Courses"));
        menu.add(new MenuItem("Veggie Pasta", 12.50, "Main Courses"));
        menu.add(new MenuItem("Beef Burger", 13.00, "Main Courses"));

        // Desserts (2)
        menu.add(new MenuItem("Chocolate Cake", 7.00, "Desserts"));
        menu.add(new MenuItem("Ice Cream", 5.50, "Desserts"));

        // Drinks (2)
        menu.add(new MenuItem("Soft Drink", 3.00, "Drinks"));
        menu.add(new MenuItem("Coffee", 4.00, "Drinks"));

        // Seasonal Special (1)
        menu.add(new MenuItem("Chef's Seasonal Dish", 18.00, "Seasonal Special"));
    }

    public List<MenuItem> getAllMenuItems() {
        return menu;
    }

    public MenuItem getMenuItemByName(String name) {
        return menu.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}