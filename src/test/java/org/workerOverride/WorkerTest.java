package org.workerOverride;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {
    @Test
    @DisplayName("Worker: calculateSalary returns hours * pricePerHour")
    void testWorkerCalculateSalary() {

        Worker worker = new Worker("John", "Smith", 12.0);
        assertEquals(1920.0, worker.calculateSalary(160), 0.01);
    }

    @Test
    @DisplayName("Worker: calculateSalary with 0 hours returns 0")
    void testWorkerCalculateSalaryZeroHours() {

        Worker worker = new Worker("John", "Smith", 12.0);
        assertEquals(0.0, worker.calculateSalary(0), 0.01);
    }

    @Test
    @DisplayName("Worker: getters return correct values")
    void testWorkerGetters() {

        Worker worker = new Worker("John", "Smith", 12.0);
        assertEquals("John", worker.getName());
        assertEquals("Smith", worker.getSurname());
        assertEquals(12.0, worker.getPricePerHour(), 0.01);
    }

    @Test
    @DisplayName("OnsiteWorker: calculateSalary includes fuel allowance")
    void testOnsiteCalculateSalary() {

        OnsiteWorker.setFuelAllowance(150.0); // reset before test
        OnsiteWorker onsiteWorker = new OnsiteWorker("Mary", "Johnson", 15.0);
        assertEquals(2550.0, onsiteWorker.calculateSalary(160), 0.01);
    }

    @Test
    @DisplayName("OnsiteWorker: changing fuel allowance affects calculation")
    void testOnsiteFuelAllowanceChange() {

        OnsiteWorker onsiteWorker = new OnsiteWorker("Mary", "Johnson", 15.0);
        OnsiteWorker.setFuelAllowance(200.0);
        assertEquals(2600.0, onsiteWorker.calculateSalary(160), 0.01);
        OnsiteWorker.setFuelAllowance(150.0); // restore
    }

    @Test
    @DisplayName("OnsiteWorker: fuel allowance is shared between instances")
    void testOnsiteFuelAllowanceShared() {

        OnsiteWorker.setFuelAllowance(150.0);
        OnsiteWorker onsiteWorker1 = new OnsiteWorker("Mary", "Johnson", 15.0);
        OnsiteWorker onsiteWorker2 = new OnsiteWorker("Anna", "Brown", 10.0);

        OnsiteWorker.setFuelAllowance(300.0);

        assertEquals(300.0, OnsiteWorker.getFuelAllowance(), 0.01);
        assertEquals(160 * 15.0 + 300, onsiteWorker1.calculateSalary(160), 0.01);
        assertEquals(160 * 10.0 + 300, onsiteWorker2.calculateSalary(160), 0.01);

        OnsiteWorker.setFuelAllowance(150.0); // restore
    }

    @Test
    @DisplayName("OnsiteWorker: is a subclass of Worker")
    void testOnsiteInheritance() {

        OnsiteWorker onsiteWorker = new OnsiteWorker("Mary", "Johnson", 15.0);
        assertInstanceOf(Worker.class, onsiteWorker);
    }

    @Test
    @DisplayName("OnlineWorker: calculateSalary includes internet fee")
    void testOnlineCalculateSalary() {

        OnlineWorker o = new OnlineWorker("Peter", "Williams", 18.0);
        assertEquals(2930.0, o.calculateSalary(160), 0.01);
    }

    @Test
    @DisplayName("OnlineWorker: calculateSalary with 0 hours returns only the internet fee")
    void testOnlineCalculateSalaryZeroHours() {

        OnlineWorker o = new OnlineWorker("Peter", "Williams", 18.0);
        assertEquals(50.0, o.calculateSalary(0), 0.01);
    }

    @Test
    @DisplayName("OnlineWorker: is a subclass of Worker")
    void testOnlineInheritance() {

        OnlineWorker o = new OnlineWorker("Peter", "Williams", 18.0);
        assertInstanceOf(Worker.class, o);
    }
}
