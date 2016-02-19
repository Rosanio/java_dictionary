import java.util.*;

public class Word {
  private static ArrayList<Word> words = new ArrayList<Word>();
  private ArrayList<Definition> mDefinitions;

  private String mWord;

  public Word(String word) {
    mWord = word;
    words.add(this);
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Word> all() {
    return words;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public static void clearWords() {
    words = new ArrayList<Word>();
  }
}
