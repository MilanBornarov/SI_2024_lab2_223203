import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {

    private List<Item> list(Item... elems) { return new ArrayList<>(Arrays.asList(elems)); }

    @Test
    void expectedExceptionTest(){
        RuntimeException ex;

        //allItems = null
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 95));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));
        //Invalid barcode
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list(new Item("produkt2", "123456789x", 100, 0)), 95));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
        //No barcode
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list(new Item("nebitno", null, 100, 0)), 95));
        assertTrue(ex.getMessage().contains("No barcode!"));

    }

    @Test
    void expectedExecutionTest(){
        System.out.println("Execution tests:");
        //Normalen test case
        assertTrue(SILab2.checkCart(list(new Item("produkt1", "0123456789", 350, 0.1f)), 95));
        //Name = "",  barcode = ""
        assertFalse(SILab2.checkCart(list(new Item("", "", 100, 0)), 95));
    }

}
