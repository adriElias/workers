package org.workerOverride;

public class OnsiteWorker extends Worker {
    private static double fuelAllowance = 150.0;

    public OnsiteWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    public static double getFuelAllowance() {
        return fuelAllowance;
    }

    public static void setFuelAllowance(double fuelAllowance) {
        OnsiteWorker.fuelAllowance = fuelAllowance;
    }

    @Override
    public String toString() {
        return "[Onsite] " + super.toString() + " | Fuel allowance: " + fuelAllowance + "€";
    }

    @Override
    public double calculateSalary(int hoursWorked) {
        return (hoursWorked * getPricePerHour()) + fuelAllowance;
    }

    @Deprecated
    public double calculateOldSalary(int hourWorked){
        return hourWorked * getPricePerHour();
    }
}
