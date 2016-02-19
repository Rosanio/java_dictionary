import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class DefinitionTest {

  @Test
  public void definition_initializesCorrectly() {
    Definition newDefinition = new Definition("definition");
    assertEquals(true, newDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_returnsDefinitionString() {
    Definition newDefinition = new Definition("The term for a baby platypus");
    assertEquals("The term for a baby platypus", newDefinition.getDefinition());
  }
}
