import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile{
	
	private String path;
	private Boolean append_to_file = true;
	
	public WriteFile(String file_path_out){
		path = file_path_out;
	}
	
	public WriteFile(String file_path_out , boolean append_value) {
		path = file_path_out;
		append_to_file = append_value;
	}
	
	public void writeToFile(String textData) throws IOException {
		
		FileWriter write = new FileWriter( path , append_to_file);
		PrintWriter print_line = new PrintWriter(write);
		
		//Appends the text file
		print_line.printf( "%s" + "%n" , textData);
		
		print_line.close();
		
	}
}