package Proj3;

import java.util.*;     // Scanner, List

public class UI {

    Cart cart = new Cart();
    private int ch = 0;

    public void startScreen() {
        System.out.println("1. Display All Vegetables");
        System.out.println("2. Display my Cart");
        System.out.println("0. Exit");
    }

    private int getUserInput() throws NumberFormatException {
        Scanner in = new Scanner(System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }

    private void addProductToCart() {
        int pid = getUserInput();
        cart.addProductToCartByPID(pid);
    }

    private void removeProductFromCart() {
        int pid = getUserInput();
        cart.removeProductByPID(pid);
    }

    public void storeProductsMenu() {
        System.out.println("1. Add item to my Cart");
        System.out.println("2. Remove from my Cart");
        System.out.println("0. Exit");
    }

    private void displayStoreProducts() {
        List<Product> products = new Products().getProducts();
        for (Product prod : products) {
            System.out.println(
                    prod.getPid() + "- " +
                            prod.getName() + " " +
                            prod.getPrice() + " " +
                            prod.getStock()
            );
        }
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void innerChoice1() {
        switch (ch) {
            case 1:
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:
                break;
        }
    }

    public void menu() {
        do {
            startScreen();
            getUserInput();

            switch (ch) {
                case 1:
                    displayStoreProducts();
                    storeProductsMenu();
                    getUserInput();
                    innerChoice1();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:

                    break;
            }
        } while (ch != 0);
    }

    public UI() {
        menu();
    }

}