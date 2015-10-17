package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

	public static int add(String text){
		String num = text;
		if (num.startsWith("//[")) {
			String deliminator = text.substring(text.indexOf("[") +1, text.lastIndexOf("]"));
			num = num.replace("[", "");
			num = num.replace("]", "");
			num = num.replace(deliminator, "*");
			num = convertDelimiters(num);

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