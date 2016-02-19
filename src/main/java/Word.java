import java.util.*;

public class Word {
  private static ArrayList<Word> words = new ArrayList<Word>();
  private ArrayList<Definition> mDefinitions;

  private String mWord;
  private Integer mId;

  public Word(String word) {
    mWord = word;
    words.add(this);
    mDefinitions = new ArrayList<Definition>();
    mId = words.size();
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

  public void clearDefinitions() {
    mDefinitions = new ArrayList<Definition>();
  }

  public Integer getId() {
    return mId;
  }

  public static Word find(Integer id) {
    try{
      return words.get(id-1);
    } catch(IndexOutOfBoundsException e) {
      System.err.println("IndexOutOfBoundsException: " + e.getMessage());
      return null;
    }
  }
}
