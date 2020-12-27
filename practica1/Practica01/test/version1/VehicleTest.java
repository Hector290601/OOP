/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hrmha
 */
public class VehicleTest {
    
    public VehicleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setMaxLoad method, of class Vehicle.
     */
    @Test
    public void testSetMaxLoad() {
        System.out.println("setMaxLoad");
        double value = 0.0;
        Vehicle instance = new Vehicle();
        instance.setMaxLoad(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoad method, of class Vehicle.
     */
    @Test
    public void testGetLoad() {
        System.out.println("getLoad");
        Vehicle instance = new Vehicle();
        double expResult = 0.0;
        double result = instance.getLoad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxLoad method, of class Vehicle.
     */
    @Test
    public void testGetMaxLoad() {
        System.out.println("getMaxLoad");
        Vehicle instance = new Vehicle();
        double expResult = 0.0;
        double result = instance.getMaxLoad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
