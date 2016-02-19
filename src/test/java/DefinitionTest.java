import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class DefinitionTest {

  @Test
  public void definition_initializesCorrectly() {
    Definition newDefinition = new Definition("definition");
    assertEquals(true, newDefinition instanceof Definition);
  }
}
