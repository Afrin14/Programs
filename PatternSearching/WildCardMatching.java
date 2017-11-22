
public class WildCardMatching {

	public boolean isMatching(String s, String t){
		char str[] = s.toCharArray();
		char pattern[] = t.toCharArray();
		
		int wildCount = 0;
		boolean isFirst = true;
		
		for(int i = 0; i < pattern.length; i++){
			if(pattern[i] == '*'){
				if(isFirst){
					pattern[wildCount++] = pattern[i];
					isFirst = false;
				}
				else{
					pattern[wildCount++] = pattern[i];
					isFirst = true;
				}
				
			}
			
		}
		
		
		boolean T[][] = new boolean[str.length+1][wildCount+1];
		if(wildCount > 0 && pattern[0] == '*'){
			T[0][1] = true;
		}
		
		
		T[0][0] = true;
		
		for(int j = 1; j < T.length; j++){
			for(int k = 1; k < T[0].length; k++){
				if(pattern[k-1] == '?' || str[j-1] == pattern[k-1]){
					T[j][k] = T[j-1][k-1];
				}
				else if(pattern[k-1] == '*'){
					T[j][k] = T[j-1][k]||T[j][k-1];
				}
				
			}
			
		}
		
		return T[str.length][wildCount];
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildCardMatching wcm = new WildCardMatching();
		System.out.println(wcm.isMatching("xaylmz", "x?y*z"));
	}

}
