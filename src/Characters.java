
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Characters {
	
	private BufferedReader br;
	private File charFile;
	
	public Characters(boolean ext){
		charFile = ext?new File("list_ext.lst"):new File("list.lst");
		if (!charFile.exists()){
			System.err.println("error");
			return;
		}
	}
	
	public ArrayList<String> getCharsForLetter(String c){
		
		String line="";
		boolean found=false;
		try {
			br = new BufferedReader(new FileReader(charFile));
			
			while((line = br.readLine())!=null){
				if(line.startsWith(c.toUpperCase())){
					line = line.substring(3);
					found=true;
					break;
				}
			}
			
		} catch (IOException e) {
			System.err.println("exception reading file");
		}
		
		line=found?line:"null";
		
		ArrayList<String> aux = new ArrayList<String>();
		aux.addAll(Arrays.asList(line.split(",")));
		
		return aux;
		
	}

}
