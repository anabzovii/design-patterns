package lab3.adapter;

import lab3.decorator.Cooker;

public class CookerAdapter implements BarmenObligations {
    Cooker cooker;
    public CookerAdapter(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void prepareCocktail()
    {
        cooker.cook();
    }

    @Override
    public int showFinalSalary() {
        return cooker.finalSalary();
    }
}
