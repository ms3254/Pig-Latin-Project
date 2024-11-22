import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    String title = input.getTitle();
    title = translate(title);
    translatedBook.setTitle(title);

    for (int i=0;i<input.getLineCount();i++){
      String line = input.getLine(i);
      translatedBook.appendLine(translate(line));
    }

    return translatedBook;
  }

  public static String translate(String input)
  {
    String result = "";
    String word = "";
    int startIndex = 0;

    boolean wasLetter = false;
    for (int i=0;i<input.length();i++){
      boolean isLetter = Character.isLetter(input.charAt(i));
      if (wasLetter!=isLetter){
        //start of word, end of nonword
        if (isLetter){
            //add nonword
            String nonWord = input.substring(startIndex, i);
            result += nonWord;
            //System.out.println("nonWord: " + nonWord);
            //System.out.println("wasLetter: " + wasLetter);
            //System.out.println("i: " + i);
        //start of nonword, end of word
        } else {
          //add word
          word = input.substring(startIndex,i);
          result += translateWord(word);
          if (i==input.length()-1){
            result += input.substring(i);
          }
        }
        startIndex = i;
        wasLetter = isLetter;
      //last letter of string
      } else if (isLetter && i==input.length()-1){
        word = input.substring(startIndex);
        result += translateWord(word);
      } else if ((!(isLetter)) && i==input.length()-1){
        result += input.substring(startIndex);
      }
    }
    return result;
  }

  private static String translateWord(String input)
  {
    //System.out.println("translateWord: '" + input + "'");
    String result1 = input;
    String vowels = "aeiouyAEIOUY";
    String endpart = "";
    boolean wasFirstCapital = false;
    boolean wholeCapital = true;
    if (Character.isUpperCase(input.charAt(0))){
      input = lowercaseFirstLetter(input);
      wasFirstCapital = true;
    }
    if (input.length()>1){
      for (int i=0;i<input.length()-1;i++){
        if (!(Character.isUpperCase(input.charAt(i)))){
          wholeCapital = false;
        } else {
          wholeCapital = true;
        }
      }
    }
    if (input.length()==1){
      if (Character.isUpperCase(input.charAt(0))){
        result1 += "AY";
        return result1;
      } else {
        result1 += "ay";
        return result1;
      }
    }
    for (int i=0; i<input.length(); i++){
      if (vowels.indexOf(input.substring(i,i+1))>=0){
        endpart += input.substring(0,i);
        result1 = result1.substring(i);
        if (wholeCapital){
          result1 += endpart + "AY";
        } else {
          result1 += endpart + "ay";
        }
        break;
      }
    }
    if (wasFirstCapital==true){
      result1 = capitalizeFirstLetter(result1);
    }
    if (wholeCapital==true){
      result1 = result1.toUpperCase();
    }
    return result1;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  private static String capitalizeFirstLetter(String input) {
    String firstLetter = input.substring(0,1);
    input = input.replaceFirst(firstLetter,firstLetter.toUpperCase());
    return input;
  }
  private static String lowercaseFirstLetter(String input){
    String firstLetter = input.substring(0,1);
    input = input.replaceFirst(firstLetter,firstLetter.toLowerCase());
    return input;
  }
}