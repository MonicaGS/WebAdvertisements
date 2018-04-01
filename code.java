/*import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class code {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = "C:\\Users\\monica g\\Desktop\\set1-cl.txt";
		//String file = "C:\\Users\\monica g\\Desktop\\set2-actor.txt";
		
		BufferedReader br = null;
		FileReader fr = null;
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		
	    String line;
	    int firstCol,secondCol,count=0;
	    
		while ((line = br.readLine()) != null) {
			String arrayLine[]= line.split("\\s+"); // here you are splitting with whitespace 
		    firstCol = Integer.parseInt(arrayLine[0]);
		    secondCol=Integer.parseInt(arrayLine[1]);
		    System.out.println(firstCol+" "+secondCol);
		    count++;
		}
		System.out.println(count);
	}
}*/