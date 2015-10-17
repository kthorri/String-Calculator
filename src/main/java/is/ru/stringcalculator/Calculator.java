package is.ru.stringcalculator;

import java.util.ArrayList;
import  java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		String num = text;
		//System.out.println(num);

		if (num.startsWith("//[")) {
			String delim = text.substring(text.indexOf("[") + 1, text.lastIndexOf("]"));
			delim = delim.replace("[", "");
			String[] delimarr = delim.split("]");
			StringBuilder builder = new StringBuilder();
			for(String s : delimarr) {
			    builder.append(Pattern.quote(s));
			    builder.append("|");
			}
			String delimiter = builder.toString();
			delimiter = delimiter.substring(0, delimiter.length() - 1);
			String numbers = text.substring(text.indexOf("\n") + 1, text.length());
			return sum(splitNumbers(numbers, delimiter));


		}
		if (num.contains("//")) {
			num = convertDelimiters(text);
		}
		if(num.equals("")){
			return 0;
		}
		else if(num.contains(",") | num.contains("\n")){
			return sum(splitNumbers(num));
		}
		else
			return 1;
	}

	private static String convertDelimiters(String original) {
		String delim = original.substring(2,3);
		original = original.replace(delim, ",");
		String shorterstr = original.substring(4, original.length());
		return String.valueOf(shorterstr);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}
	private static String[] splitNumbers(String numbers, String delimiter){
		return numbers.split(delimiter);
	}
      
  private static int sum(String[] numbers){
 	  int total = 0;
 	  ArrayList<Integer> negatives = new ArrayList<Integer>();
    for(String number : numbers){
    	Integer n = toInt(number);
    	if (n < 0) {
    		negatives.add(n);
    	}
    	else if (n <= 1000) {
    		total += toInt(number);
    	}
		}
		if (!negatives.isEmpty()) {
			String negs = negatives.toString();
			negs = negs.substring(1, negs.length() - 1);
			throw new RuntimeException("Negatives not allowed: " + negs);
		}
		return total;
  }
}