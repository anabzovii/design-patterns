package lab4;

import lab4.command.CardTypeDeterminerUtil;
import lab4.command.cards.CardFunctionality;
import lab4.command.cards.CreditCardStrategy;
import lab4.command.cards.PaypalStrategy;
import lab4.command.functionality.*;
import lab4.iterator.FoodBar;
import lab4.iterator.FoodCollection;
import lab4.observer.CardUsage;
import lab4.observer.CardUsageSubscriber;
import lab4.observer.Observer;
import lab4.strategy.Food;
import lab4.strategy.ShoppingMenu;

public class Main {
    public static void main(String[] args) {
        //Strategy
        ShoppingMenu shoppingMenu = new ShoppingMenu();

        Food food1 = new Food("burgher", 70);
        Food food2 = new Food("pizza", 100);

        shoppingMenu.addFood(food1);
        shoppingMenu.addFood(food2);
        shoppingMenu.pay(new PaypalStrategy("email@eple.com", "fdsfb"));
        shoppingMenu.pay(new CreditCardStrategy("Jack Huster", "5535", "786", "12/15"));

        //Iterator
        FoodCollection nc = new FoodCollection();
        nc.addFood("asd", 43);
        nc.addFood("rew", 53);
        FoodBar foodBar = new FoodBar(nc);
        foodBar.printFoodPrices();

        //Command
        //Creating the receiver object
        CreditCardStrategy creditCardStrategy = new CreditCardStrategy();
        PaypalStrategy paypalStrategy = new PaypalStrategy();
        CardFunctionality creditCard = CardTypeDeterminerUtil.getCardType(creditCardStrategy);
        CardFunctionality paypalCard = CardTypeDeterminerUtil.getCardType(paypalStrategy);

        //creating command and associating with receiver
        Command transfer = new Transfer(creditCard);

        //Creating invoker and associating with Command
        FunctionalityInvoker invoker = new FunctionalityInvoker(transfer);

        //perform action on invoker object
        String transferInvoker = invoker.execute();

        Command deposite = new Deposite(creditCard);
        invoker = new FunctionalityInvoker(deposite);
        String depositInvoker = invoker.execute();

        Command payment = new Payment(paypalCard);
        invoker = new FunctionalityInvoker(payment);
        String paymentInvoker = invoker.execute();

        //Observer
        //create subject
        CardUsage creditCardUsage = new CardUsage();
        CardUsage paypalUsage = new CardUsage();

        //create observers
        Observer creditCardObserver = new CardUsageSubscriber("Credit Card observer ");
        Observer paypalObserver = new CardUsageSubscriber("Paypal Observer ");


        //register observers to the subject
        creditCardUsage.register(creditCardObserver);
        paypalUsage.register(paypalObserver);


        //attach observer to subject
        creditCardObserver.setSubject(creditCardUsage);
        paypalObserver.setSubject(paypalUsage);

        //check if any update is available
        creditCardObserver.update();
        paypalObserver.update();

        //now send message to subject
        creditCardUsage.postMessage(transferInvoker);
        paypalUsage.postMessage(paymentInvoker);
    }
}

