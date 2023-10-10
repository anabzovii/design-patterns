package lab4.command.functionality;

import lab4.command.cards.CardFunctionality;

public class Transfer implements Command {

    private CardFunctionality cardFunctionality;

    public Transfer(CardFunctionality fs){
        this.cardFunctionality =fs;
    }
    @Override
    public String execute() {
        return this.cardFunctionality.cardPayments();
    }

}
