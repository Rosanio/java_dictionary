import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class WordTest {

  @Test
  public void word_initializesCorrectly() {
    Word newWord = new Word("Peanuts");
    assertEquals(true, newWord instanceof Word);
  }
}
