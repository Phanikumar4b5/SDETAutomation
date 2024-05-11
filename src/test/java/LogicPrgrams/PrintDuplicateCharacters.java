package LogicPrgrams;

import java.util.*;

public class PrintDuplicateCharacters {

	public static void main(String[] args) {
		String str="Phani kumar ";
		char ch[]=str.toCharArray();
		Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		for(Character c:ch) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		
		//Approach 1 to print values in map
		Set<Map.Entry<Character,Integer>> set=map.entrySet();
		for(Map.Entry<Character,Integer> entry:set) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
//		Iterator<Character> itr=map.keySet().iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		//Approach 1 to print values in map
		map.forEach((k,v)->System.out.println("key is "+k+" value is "+v));
	}

}
