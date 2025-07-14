import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
//q-1
    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine(5);
    }
//q-2
    @Test
    void testInitialStateIsPoweredOff() {
        assertFalse(vendingMachine.isPoweredOn());
    }
//q-3
    @Test
    void testPowerOnChangesStateToOn() {
        vendingMachine.powerOn();
        assertTrue(vendingMachine.isPoweredOn());
    }
//q-4
    @Test
    void testPowerOffAfterPowerOnSetsStateToFalse() {
        vendingMachine.powerOn();
        vendingMachine.powerOff();
        assertFalse(vendingMachine.isPoweredOn());
    }
//q-5
    @Test
    void testPowerOnTwiceThrowsException() {
        vendingMachine.powerOn();
        assertThrows(IllegalStateException.class, vendingMachine::powerOn);
    }
//q-6
    @Test
    void testDispenseDecreasesItemCountByOne() {
        vendingMachine.powerOn();
        int initialCount = vendingMachine.getItemCount();
        vendingMachine.dispenseItem();
        assertEquals(initialCount - 1, vendingMachine.getItemCount());
    }
//q-7
    @Test
    void testDispenseWhenPoweredOffThrowsException() {
        assertThrows(IllegalStateException.class, vendingMachine::dispenseItem);
    }
//q-8
    @Test
    void testDispenseWhenOutOfStockThrowsException() {
        vendingMachine = new VendingMachine(1);
        vendingMachine.powerOn();
        vendingMachine.dispenseItem(); // 0 left
        assertThrows(IllegalStateException.class, vendingMachine::dispenseItem);
    }
//q-9
    @Test
    void testMultipleDispensesReduceItemCountCorrectly() {
        vendingMachine.powerOn();
        vendingMachine.dispenseItem();
        vendingMachine.dispenseItem();
        assertEquals(3, vendingMachine.getItemCount());
    }
//q-10
    @Test
    void testTwoReferencesSameInstance() {
        VendingMachine anotherRef = vendingMachine;
        assertSame(vendingMachine, anotherRef);
    }
//q-11
    @Test
    void testTwoDifferentObjectsNotSame() {
        VendingMachine vm1 = new VendingMachine(5);
        VendingMachine vm2 = new VendingMachine(5);
        assertNotSame(vm1, vm2);
    }
//q-12
    @Test
    void testVendingMachineIsNotNull() {
        assertNotNull(vendingMachine);
    }
//q-13
    @Test
    void testDispenseCompletesWithin150Milliseconds() {
        vendingMachine.powerOn();
        assertTimeout(java.time.Duration.ofMillis(150), () -> vendingMachine.dispenseItem());
    }
//q-14
    @Test
    void testArrayEquals() {
        int[] expected = {5, 3, 0};
        int[] actual = {5, 3, 0};
        assertArrayEquals(expected, actual);
    }
}
