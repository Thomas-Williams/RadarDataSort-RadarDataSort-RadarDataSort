import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class ReadFile {
	
	private String path;
	private String path_out;
	private boolean append;
	private double lowerLat;
	private double upperLat;
	private double lowerLon;
	private double upperLon;
	
	public ReadFile (String file_path_in, String file_path_out , boolean append_value, double lowerLat, double upperLat, double lowerLon, double upperLon) {
		path = file_path_in;
		path_out = file_path_out;
		append = append_value;
		lowerLat = lowerLat;
		upperLon = upperLat;
		lowerLon = lowerLon;
		upperLon = upperLon;
		
	}
	
	//Method to read the file and store it in an array
	public String[] OpenFile() throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		
		for (int i = 0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
			
			//Extracts the first two pieces of data and line number
			String fullData = textData[i];
			String[] splitData = fullData.split(",");
			String textLat = splitData[1];
			String textLon = splitData[2];
			Double numLat = new Double("0");
			Double numLon = new Double("0");
			
			//Converts the contents of the text data into doubles (hopefully)
			double Lat = numLat.valueOf(textLat);
			double Lon = numLon.valueOf(textLon);
			
			//If the data falls within the region being looked at calls WriteFile to add it to the next line of a text file
			if ((Lat <= upperLat && Lat >= lowerLat) && (Lon <= (upperLon) && Lon >= (lowerLon))) {
				WriteFile write = new WriteFile(path_out, append);
			}
			
			
		}
		
		
		textReader.close();
		return textData;

	}
	
	int readLines() throws IOException {
		
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		int numberOfLines = 0;
		
		while ((aLine = bf.readLine()) != null) {
			numberOfLines++;
		}
		bf.close();
		
		return numberOfLines;
		
	}
}