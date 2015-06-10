import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class FileData {
	
	public static void main(String[] args) throws IOException {
		
		//All variables that can be modified by the user
		String file_path_in = "/Users/John_Appleseed/Desktop/DATA Documents/Data/FILE";
		String file_path_out = "/Users/John_Appleseed/Desktop/DATA Documents/Data/DESTINATION.txt";
		Boolean append = true;
		double Lat1 = 76.00;
		double Lat2 = 76.8;
		double Lon1 = -69.17;
		double Lon2 = -65.93;
		
		//Executes ReadFile if able otherwise throws an exception
		try {
			ReadFile file = new ReadFile(file_path_in, file_path_out, append, Lat1, Lat2, Lon1, Lon2);
			String[] aryLines = file.OpenFile();
			
			//Print the array that represents the text file
			for (int i = 0; i < aryLines.length; i++ ) {
			System.out.println( aryLines[ i ] ) ;
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}