import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    // Add code here to populate translatedBook with a translation of the input book.
    // Curent do-nothing code will return an empty book.

    return translatedBook;
  }

  public static String translate(String input)
  {
    String result = "";
    String word = "";
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    /*for (int i=0;i<input.length();i++){
      if (Character.isLetterOrDigit(input.charAt(i))){
        while (Character.isLetterOrDigit(input.charAt(i+1))){
          word += input.charAt(i);
        }
        word = translateWord(word);
        result += word;
      }
    }*/

    return result;
  }

  private static String translateWord(String input)
  {
    //System.out.println("translateWord: '" + input + "'");
    String result1 = input;
    String vowels = "aeiou";
    String vowelsCap = "AEIOU";
    String consoCap = "BCDFGHJKLMNPQRSTVWXYZ";
    String endpart = "";
    for (int i=0; i<input.length(); i++){
      if (vowels.indexOf(input.substring(i,i+1))>=0){
        endpart += input.substring(0,i);
        result1 = result1.substring(i);
        result1 += endpart + "ay";
        return result1;
      }
    }
    return result1;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  private static String capitalizeFirstLetter(String input) {
    return input.replace(input.substring(0,0+1),input.substring(0,0+1).toUpperCase());
  }
  private static String wordFinder(String input){
    boolean wasLetter = false;
    for (int i=0;i<input.length();i++){
      boolean isLetter = Character.isLetterOrDigit(input.charAt(i));
      if (wasLetter!=isLetter){
        if (isLetter){
          return input.substring(i,i+1);
        }
        else {
          
        }
      }
    }
    return input;
  }
}