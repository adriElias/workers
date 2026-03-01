package org.workerOverride;

public class App {
    public static void main(String[] args) {
        Worker worker = new Worker("John", "Smith", 12.0);
        OnsiteWorker onsiteWorker = new OnsiteWorker("Mary", "Johnson", 15.0);
        OnlineWorker onlineWorker = new OnlineWorker("Peter", "Williams", 18.0);

        int hours = 160;
        System.out.println("--- WORKER ---");
        System.out.println("Worker: " + worker);
        System.out.println("Salary (" + hours + "hours): " + worker.calculateSalary(hours) + "€");

        System.out.println("--- ONSITE WORKER ---");
        System.out.println("Worker: " + onsiteWorker);
        System.out.println("Salary (" + hours + "hours): " + onsiteWorker.calculateSalary(hours) + "€");

        System.out.println("--- ONLINE WORKER ---");
        System.out.println("Worker: " + onlineWorker);
        System.out.println("Salary (" + hours + "hours): " + onlineWorker.calculateSalary(hours) + "€");

        System.out.println("--- DEPRECATED ---");
        printDeprecatedOnsiteSalary(onsiteWorker, hours);
        printDeprecatedOnlineSalary(onlineWorker, hours);
    }

    @SuppressWarnings("deprecation")
    private static void printDeprecatedOnsiteSalary(OnsiteWorker onsiteWorker, int hours) {
        double oldSalary = onsiteWorker.calculateOldSalary(hours);
        System.out.println("[Deprecated] Onsite old salary (no fuel): " + oldSalary + "€");
    }

    @SuppressWarnings("deprecation")
    private static void printDeprecatedOnlineSalary(OnlineWorker onlineWorker, int hours) {
        double oldSalary = onlineWorker.calculateOldSalary(hours);
        System.out.println("[Deprecated] Online old salary (no internet fee): " + oldSalary + "€");
    }
}