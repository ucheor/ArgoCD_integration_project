package com.restaurant.ordering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public String showMenu(Model model) {
        model.addAttribute("menuItems", menuService.getAllMenuItems());
        return "menu";
    }

    @PostMapping("/order")
    @ResponseBody
    public Receipt processOrder(@RequestBody Map<String, Integer> order) {
        Receipt receipt = new Receipt();
        List<OrderItem> items = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey();
            Integer quantity = entry.getValue();

            if (quantity != null && quantity > 0) {
                MenuItem menuItem = menuService.getMenuItemByName(itemName);
                if (menuItem != null) {
                    items.add(new OrderItem(menuItem, quantity));
                }
            }
        }

        receipt.setItems(items);
        return receipt;
    }
}