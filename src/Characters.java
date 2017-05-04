
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Characters {
	
	private HashMap<String, List<String>> chars = new HashMap<String, List<String>>();
	
	public Characters(){
		chars.put("a", Arrays.asList("a", "A", "4", "@", "∂", "λ", "α", "Δ"));
		chars.put("b", Arrays.asList("b", "B", "6", "ß", "|3", "β"));
		
		chars.put("null", Arrays.asList("null"));
	}
	
	public ArrayList<String> getCharsForLetter(String c){
		ArrayList<String> aux = new ArrayList<String>();
		if (!chars.containsKey(c.toLowerCase())) c="null";
		for(int i=0; i<chars.get(c.toLowerCase()).size(); i++){
			aux.add(chars.get(c.toLowerCase()).get(i));
		}
		return aux;
		
	}

}
