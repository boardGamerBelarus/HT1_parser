package module1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

/*Reader - encapsulates reading from source file */ 
public class Reader {

	ArrayList<String> arrayList = null;
	String SOURCE_PATH = "";
	File file;
	static String USAGE = "USAGE: java -jar ht1.jar SOURCE_FILE LOG_FILE";
	int ByteOrderMark = 65279;

	public Reader(String[] args) {
		try {
			this.SOURCE_PATH = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid SOURCE_FILE argument");
			System.out.println(USAGE);
			System.exit(-1);
		}
	}

	public ArrayList<String> read() {
		Statistic.startTotalTime();

		try {
			file = FileUtils.getFile(SOURCE_PATH);
		} catch (Exception e) {
			System.out.println("Source file is not found or corrupted");
			System.exit(-1);
		}
		try {
			arrayList = (ArrayList<String>) FileUtils.readLines(file, "UTF-8");
			
			if (!arrayList.get(0).isEmpty() && (int) arrayList.get(0).charAt(0) == ByteOrderMark) {
				arrayList.set(0, arrayList.get(0).substring(1));
			}
		} catch (IOException e) {
			System.out.println("Source file is not found or corrupted");
			System.exit(-1);
		}
		return arrayList;
	}

}
