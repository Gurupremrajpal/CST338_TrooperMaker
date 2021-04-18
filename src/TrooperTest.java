import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrooperTest {

    @Test
    void testAddToUnit() {
        HashMap<String, List<Trooper>> units = new HashMap<>();
        RebelTrooper luke = new RebelTrooper("Blue", 5, "Luke");
        StormTrooper finn = new StormTrooper("FN", 2187);

        assertFalse(units.containsKey(finn.getUnit()));
        Trooper.addToUnit(units,finn);
        assertTrue(units.containsKey(finn.getUnit()));

        assertFalse(units.containsKey(luke.getUnit()));
        Trooper.addToUnit(units,luke);
        assertTrue(units.containsKey(luke.getUnit()));

    }

    @Test
    void testAttack() {
        RebelTrooper luke = new RebelTrooper("Blue", 5, "Luke");
        StormTrooper finn = new StormTrooper("FN", 2187);

        assertTrue(luke.attack(luke,10));
        assertTrue(finn.attack(luke,1));

        assertTrue(finn.attack(luke,12));
        assertFalse(finn.attack(luke,11));

        assertFalse(finn.attack(new StormTrooper("TK",421),12));

        assertFalse(luke.attack(new RebelTrooper("Black",1,"Poe"),7));

        assertTrue(luke.attack(finn,6));
        assertTrue(luke.attack(finn,3));
        assertFalse(luke.attack(finn,2));

    }

    @Test
    void testGetUnit() {
        StormTrooper finn = new StormTrooper("FN", 2187);
        assertEquals("FN",finn.getUnit());
    }

    @Test
    void testSetUnit() {
        StormTrooper finn = new StormTrooper("FN", 2187);
        assertEquals("FN",finn.getUnit());
        finn.setUnit("TK");
        assertEquals("TK",finn.getUnit());
        assertNotEquals("FN",finn.getUnit());
    }

    @Test
    void testGetNumber() {
        RebelTrooper jyn = new RebelTrooper("Rogue", 1, "Jyn");
        assertEquals(1,jyn.getNumber());

    }

    @Test
    void testSetNumber() {
        RebelTrooper jyn = new RebelTrooper("Rogue", 1, "Jyn");
        assertEquals(1,jyn.getNumber());
        jyn.setNumber(42);
        assertEquals(42,jyn.getNumber());
        assertNotEquals(1,jyn.getNumber());
    }

    @Test
    void testMarch() {
        RebelTrooper luke = new RebelTrooper("Blue", 5, "Luke");
        StormTrooper finn = new StormTrooper("FN", 2187);

//        assertEquals(Math.ceil(48.75),luke.march(13));
//        assertEquals(Math.floor(71.5),finn.march(13));
        assertEquals((48.75),luke.march(13));
        assertEquals((71.5),finn.march(13));

    }

    @Test
    void getSoldierCount() {
        for(int i = 0; i < 10; i++){
            if(i<5){
                new StormTrooper("FN", i);
            }else{
                new RebelTrooper("Blue", i, "luke"+i);
            }
        }

        assertEquals(5,StormTrooper.getSoldierCount());
        assertEquals(5,RebelTrooper.getSoldierCount());
    }
}