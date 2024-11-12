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
    System.out.println("translateWord: '" + input + "'");
    String result1 = input;
    String vowels = "aeiouAEIOU";
    String endpart = "";
    for (int i=0;i<vowels.length();i++){
      if (vowels.substring(i,i+1).equals(result1.substring(0,1))){
        result1 += "ay";
        return result1;
      } /*else {
        for (int j=0;j<input.length()-1;i++){
          if (input.substring(i,i+1).equals(vowels.substring(i,i+1))){
            endpart += input.substring(i,i+1);
          }
        }
        result1 += endpart + "ay";*/
      //return result1;
      }
    }
    
  return input;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}