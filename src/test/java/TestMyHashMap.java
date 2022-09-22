import org.gk.MyHashMap;
import org.gk.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMyHashMap {
   MyHashMap myHashMap = new MyHashMap();

   @Test
   public void testHashMapCreation() {
      Assertions.assertNotNull(myHashMap);
   }

   @Test
   public void testSize() {
      Assertions.assertEquals(myHashMap.size(), 0);
      ;
   }

   @Test
   public void testSort() {
      String[] array = {"Andree", "Leana", "Faviola", "Loyce", "Quincy",
              "Milo", "Jamila", "Toccara", "Nelda", "Blair", "Ernestine",
              "Chara", "Kareen", "Monty", "Rene", "Cami", "Winifred",
              "Tara", "Demetrice", "Azucena"};
      QuickSort<String> sorter = new QuickSort<>();
      sorter.quicksort(array, 0, array.length - 1);
      Assertions.assertEquals("[Andree, Azucena, Blair, Cami, Chara," +
              " Demetrice, Ernestine, Faviola, Jamila, Kareen, Leana, Loyce, Milo" +
              ", Monty, Nelda, Quincy, Rene, Tara, Toccara, Winifred" +
              "]", java.util.Arrays.toString(array));
   }
}
