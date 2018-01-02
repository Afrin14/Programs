import java.util.*;

public class Program{

	static final int MAX_CHAR = 26;

	static String getKey(String str){
		boolean[] visited = new boolean[MAX_CHAR];
		Arrays.fill(visited, false);

		for(int j = 0; j < str.length(); j++)
			visited[str.charAt(j) - 'a'] = true;

		String key = "";
	for(int i = 0; i < MAX_CHAR; i++)
	   if(visited[i])
	   		key = key + (char)('a' + i);
	

	return key;
}

    static void wordsWithSameCharSet(String words[], int n){
	
		HashMap<String, ArrayList<Integer>> hash = new HashMap<>();

		for(int i = 0; i < n; i++){
		String key = getKey(words[i]);

		if(hash.containsKey(key)){
			ArrayList<Integer> get_al = hash.get(key);
			get_al.add(i);
			hash.put(key, get_al);
		}

		else{
			ArrayList<Integer> new_al = new ArrayList<>();
		new_al.add(i);
		hash.put(key, new_al);
		}

		for(Entry<String,ArrayList<Integer>> it:hash.entrySet())
			{
			ArrayList<Integer> get = it.getValue();
			for(Integer v: get)
				System.out.print(words[v] + ",");
			System.out.println();
			}
	}
}
		public static void main(String args[]){
			String words[] = {"may", "student", "students", "tab", "bat", "flow", "wolf", "lambs", "amy", " yam", "balms","topped", "poodle"};
			int n = words.length;
			wordsWithSameCharSet(words, n);
	
			}
		}
	
	