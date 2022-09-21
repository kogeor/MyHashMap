
import org.gk.MyHashMap;
import org.gk.QuickSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMyHashMap {
    MyHashMap myHashMap = new MyHashMap();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testHashMapCreation() {
        Assertions.assertNotNull(myHashMap);
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(myHashMap.size(), 0);
    }

    @Test
    public void testSort() {
        String[] array = {"Andree", "Leana", "Faviola", "Loyce", "Quincy", "Milo", "Jamila", "Toccara", "Nelda", "Blair", "Ernestine", "Chara", "Kareen", "Monty", "Rene", "Cami", "Winifred", "Tara", "Demetrice", "Azucena"};
        QuickSort<String> sorter = new QuickSort<>();
        sorter.quicksort(array, 0, array.length - 1);
        System.out.println(java.util.Arrays.toString(array));
        Assertions.assertEquals("[Andree, Azucena, Blair, Cami, Chara, Demetrice, Ernestine, Faviola, Jamila, Kareen, Leana, Loyce, Milo, Monty, Nelda, Quincy, Rene, Tara, Toccara, Winifred]\r\n", output.toString());
    }
}
