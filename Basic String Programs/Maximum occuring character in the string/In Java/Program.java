import java.util.*;

public class Program{
	
	static final int ASCII_VALUE = 256;

	static char getMaximumRepeatingString(String str){


		int len = str.length();
	
		if(len <= 0)
			return '0';
	
		int[] count = new int[ASCII_VALUE];
		

		for(int i = 0; i < len; i++){
			count[str.charAt(i)]++;
		}

		int max_value = -1;
		char result = ' ';

		for(int i = 0; i < len; i++){
			if(max_value < count[str.charAt(i)]){
				max_value = count[str.charAt(i)];
				result = str.charAt(i);
			  }
			}
		return result;

		}

	

	public static void main(String[] args) {
		System.out.println("Enter any string");
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		System.out.println("Maximun repeating character in the string is:"+ getMaximumRepeatingString(str));
	}
}