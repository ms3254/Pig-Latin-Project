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
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    String result = translateWord(input);

    return result;
  }

  private static String translateWord(String input)
  {
    //System.out.println("translateWord: '" + input + "'");
    String result1 = input;
    String vowels = "aeiouAEIOU";
    String endpart = "";
    for (int i=0; i<input.length(); i++){
      if (vowels.indexOf(input.substring(i,i+1))>=0){
        endpart += input.substring(0,i);
        result1 = result1.substring(i);
        result1 += endpart + "ay";
        return result1;
      }
      /*if (vowels.indexOf(input.substring(i,i+1))>=0){
        System.out.println("before" + input);
        endpart += input.substring(0,i+1);
        System.out.println("endpart: " + endpart);
        result1 = input.substring(i);
        System.out.println("after:" + input);
      } else {
        result1 = input + endpart + "ay";
        break;
      }*/
    }
    return result1;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}