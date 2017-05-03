
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Characters {
	
	private HashMap<String, ArrayList<String>> chars = new HashMap<String, ArrayList<String>>();
	
	public Characters(){
		chars.put("a", (ArrayList<String>) Arrays.asList("a", "A", "4"));
	}
	
	public ArrayList<String> getCharsForLetter(String c){
		if (!chars.containsKey(c)) return null;
		else return chars.get(c);
		
	}

}
