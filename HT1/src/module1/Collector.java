package module1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*Collector - splits List of commands, gained from Reader and organizes this snippets into List of Procedures*/
public class Collector {

	Iterator<String> iterator;
	ArrayList<Procedure> procedureList;
	Procedure procedure;
	
	public ArrayList<Procedure> createInstances(ArrayList<String> arrayList) {
	
		iterator = arrayList.iterator();
		procedureList = new ArrayList<Procedure>();	
		
		while (iterator.hasNext()) {
			
		procedure = new Procedure(iterator.next().split("( \")|(\" \")|(\")"));
		procedureList.add(procedure);
		}
	
	return procedureList;
	}

}
