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
    newWord.addDefinition(newDefinition);
    assertEquals(true, newWord.getDefinitions().contains(newDefinition));
  }

  @Test
  public void getDefinition_assertThatDefinitionListForOneWordDoesNotContainDefinitionsForAnother() {
    Word newWord1 = new Word("albino");
    Word newWord2 = new Word("honkeytonk");
    Definition newDefinition1 = new Definition("really white");
    Definition newDefinition2 = new Definition("I have no idea");
    newWord1.addDefinition(newDefinition1);
    newWord2.addDefinition(newDefinition2);
    assertEquals(false, newWord1.getDefinitions().contains(newDefinition2));
  }
}
