package lab4.command;

import lab4.command.cards.CardFunctionality;
import lab4.command.cards.CreditCardStrategy;
import lab4.command.cards.PaypalStrategy;

public class CardTypeDeterminerUtil {

    public static CardFunctionality getCardType(CardFunctionality cardFunctionality) {
        if (cardFunctionality.getClass().equals(CreditCardStrategy.class)) {
            return new CreditCardStrategy();
        } else {
            return new PaypalStrategy();
        }
    }

}