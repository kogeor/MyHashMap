import org.gk.MyHashMap;
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

}
