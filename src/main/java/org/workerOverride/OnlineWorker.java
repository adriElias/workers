package org.workerOverride;

public class OnlineWorker extends Worker{
    private static final double INTERNET_FEE = 50.0;

    public OnlineWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hoursWorked) {
        return (hoursWorked * getPricePerHour()) + INTERNET_FEE;
    }

    @Override
    public String toString() {
        return "[Online] " + super.toString() + " | Internet fee: " + INTERNET_FEE + "€";
    }
}
