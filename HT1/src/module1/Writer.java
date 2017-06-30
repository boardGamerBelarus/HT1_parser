package module1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/*Writer - responsible for writing to log file*/
public class Writer {

	ArrayList<String> arrayList;
	String DESTINATION_PATH = "";
	File fileToWrite;

	public Writer(String [] args) {

		try {
			this.DESTINATION_PATH = args[1];
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid LOG_FILE argument");
			System.out.println(Reader.USAGE);
			System.exit(-1);
		}
	}

	public void write(ArrayList<String> arrayList) {

		try {
			fileToWrite = FileUtils.getFile(DESTINATION_PATH);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid destination argument");
		}
		try {
			FileUtils.writeLines(fileToWrite, arrayList);
		} catch (IOException e) {
			System.out.println("Recording to file error");
		}

	}
}
