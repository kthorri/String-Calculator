package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		String num = text;
		if (text.contains("//")) {
			char[] str = text.toCharArray();
			char[] shorterstr = new char[str.length-4];
			char delim = str[2];
			for (int i = 4; i < str.length; i++) {
				if (delim == str[i]) {
					str[i] = ',';
				}
				shorterstr[i-4] = str[i];
			}
			num = String.valueOf(shorterstr);
		}
	
		if(num.equals("")){
			return 0;
		}	
		if(num.contains(",") | num.contains("\n")){
			return sum(splitNumbers(num));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}
      
  private static int sum(String[] numbers){
 	  int total = 0;
    for(String number : numbers){
		  total += toInt(number);
		}
		return total;
  }
}