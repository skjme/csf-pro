package com.journaldev.design.strategy;

public class ShoppingCartTest {

    public static void main(String[] args) {
        ShoppingCart card = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        card.addItem(item1);
        card.addItem(item2);


        // pay by paypal
        card.pay(new PaypalStrategy("skjme2006@qq.com", "mypwd"));

        // pay by credit card
        card.pay(new CreditCardStrategy("chaseshu", "123456789681147222", "786", "12/15"));
    }
}
