package lab4.command.functionality;

import lab4.command.cards.CardFunctionality;

public class Payment implements Command {

    private CardFunctionality cardFunctionality;

    public Payment(CardFunctionality fs){
        this.cardFunctionality =fs;
    }
    @Override
    public String execute() {
        return this.cardFunctionality.cardDeposit();
    }

}