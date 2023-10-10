package lab3.decorator;

public class ProfessionalCooker extends CookerDecorator {

    private int salary;

    public ProfessionalCooker(Cooker c, int salary) {
        super(c);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int finalSalary(){
        return super.finalSalary() + getSalary();
    }
}
