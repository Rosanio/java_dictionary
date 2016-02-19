import java.util.*;

public class Word {
  private static ArrayList<Word> words = new ArrayList<Word>();

  private String mWord;

  public Word(String word) {
    mWord = word;
    words.add(this);
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Word> all() {
    return words;
  }
}
