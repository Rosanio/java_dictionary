import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class WordTest {

  @Test
  public void word_initializesCorrectly() {
    Word newWord = new Word("Peanuts");
    assertEquals(true, newWord instanceof Word);
  }

  @Test
  public void getWord_returnsWordTitle() {
    Word newWord = new Word("putz");
    assertEquals("putz", newWord.getWord());
  }

  @Test
  public void all_returnsArrayListOfAllInstancesOfWordClass() {
    Word newWord1 = new Word("toaster");
    Word newWord2 = new Word("aluminum");
    assertEquals(true, Word.all().contains(newWord1));
    assertEquals(true, Word.all().contains(newWord2));
  }

  @Test
  public void getDefinition_initiallyReturnsEmptyArrayList() {
    Word newWord = new Word("headbutt");
    assertEquals(true, newWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void addDefinition_addsNewInstanceOfDefinitionToWord() {
    Word newWord = new Word("programming");
    Definition newDefinition = new Definition("An easy job for slackers");
    assertEquals(true, newWord.getDefinition.contains(newDefinition));
  }
}
