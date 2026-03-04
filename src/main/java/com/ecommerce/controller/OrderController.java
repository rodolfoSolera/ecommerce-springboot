package com.ecommerce.controller;

import com.ecommerce.entity.User;
import jakarta.servlet.http.HttpSession;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String order(Model model) {
        model.addAttribute("adminSection","order");
        return "admin";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to SignIn.");
            return "redirect:/signin";
        }

        List<ShoppingCartController.CartItemView> shoppingCartView =
                (List<ShoppingCartController.CartItemView>) session.getAttribute("shoppingCartView");

        if (shoppingCartView == null || shoppingCartView.isEmpty()) {
            System.out.println("Cart is empty. Redirecting to home.");
            return "redirec:/";
        }

        session.setAttribute("checkoutView", shoppingCartView);

        return "redirect:/order/checkout-page";
    }

    @GetMapping("/checkout-page")
    public String checkoutPage(Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to SignIn.");
            return "redirect:/signin";
        }

        User currentUser = (User) session.getAttribute("currentUser");
        Integer cartTotalItems = (Integer) session.getAttribute("cartTotalItems");
        Double cartTotalValue = (Double) session.getAttribute("cartTotalValue");

        List<ShoppingCartController.CartItemView> checkoutView =
                (List<ShoppingCartController.CartItemView>) session.getAttribute("checkoutView");

        if (checkoutView == null || checkoutView.isEmpty()) {
            System.out.println("Cart is empty. Redirecting to home.");
            return "redirect:/";
        }

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("cartTotalItems", cartTotalItems);
        model.addAttribute("cartTotalValue", cartTotalValue);
        model.addAttribute("checkoutView", checkoutView);

        return "checkout";
    }

    @PostMapping("finalize")
    public String finalizeOrder(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to SignIn.");
            return "redirect:/signin";
        }

        User currentUser = (User) session.getAttribute("currentUser");

        List<ShoppingCartController.CartItemView> checkoutView =
                (List<ShoppingCartController.CartItemView>) session.getAttribute("checkoutView");

        if (checkoutView == null || checkoutView.isEmpty()) {
            System.out.println("Cart is empty. Redirecting to home.");
            return "redirect:/";
        }

        Integer cartTotalItems = (Integer) session.getAttribute("cartTotalItems");
        Double cartTotalValue = (Double) session.getAttribute("cartTotalValue");

        return "redirect:/order/success";
    }

    @GetMapping("success")
    public String orderSuccess(Model model, HttpSession session) {

        return "order-success";
    }
}
