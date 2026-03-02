package com.ecommerce.controller;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add")
    public String addToCart(@RequestParam Long productId, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to SignIn.");
            return "redirect:/signin";
        }

        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            System.out.println("Product with ID " + productId + " not found.");
            return "redirect:/";
        }

        Product product = productOptional.get();
        List<Product> shoppingCart;

        if (session.getAttribute("shoppingCart") != null)
            shoppingCart = (List<Product>) session.getAttribute("shoppingCart");
        else {
            shoppingCart = new ArrayList<>();
        }

        shoppingCart.add(product);
        session.setAttribute("shoppingCart", shoppingCart);

        System.out.println("Product added to cart: " + product.getName());
        System.out.println("Total items in cart: " + shoppingCart.size());

        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to SignIn.");
            return "redirect:/signin";
        }

        List<Product> shoppingCart = (List<Product>) session.getAttribute("shoppingCart");

        Map<Long, CartItemView> cartItemsMap = new HashMap<>();
        for (Product product : shoppingCart) {
            if (cartItemsMap.containsKey(product.getId())) {
                System.out.println("Incrementando produto ID: " + product.getId());
                CartItemView item = cartItemsMap.get(product.getId());
                item.incrementQuantity();
            } else {
                cartItemsMap.put(product.getId(), new CartItemView(product,1));
            }
        }

        List<CartItemView> cartItems = new ArrayList<>(cartItemsMap.values());

        int totalItems = shoppingCart.size();
        Double totalValue = cartItems.stream()
                .map(CartItemView::getSubTotal)
                .reduce(0.0, Double::sum);

        session.setAttribute("shoppingCartView", cartItems);
        session.setAttribute("cartTotalItems", totalItems);
        session.setAttribute("cartTotalValue", totalValue);

        return "redirect:/";
    }

    public static class CartItemView {

        private final Product product;
        private int quantity;

        public CartItemView(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public void incrementQuantity() {
            this.quantity++;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public Double getSubTotal() {
            return product.getPrice() * quantity;
        }
    }

}
