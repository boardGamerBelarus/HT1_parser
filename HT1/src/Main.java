import java.util.ArrayList;

import module1.Collector;
import module1.Distributor;

import module1.Procedure;
import module1.Reader;
import module1.ResultReporter;

import module1.Writer;


public class Main {

	public static void main(String[] args) {

		Reader reader = new Reader(args);
		Writer writer = new Writer(args);
		
		ArrayList<String> commandsToPerform = reader.read();

		Collector collector = new Collector();
		ArrayList<Procedure> procedureList = collector.createInstances(commandsToPerform);

		Distributor distributor = new Distributor();
		ArrayList<String> performingResults = distributor.distribute(procedureList);

		ResultReporter resultReporter = new ResultReporter(commandsToPerform, performingResults);
		ArrayList<String> finalResults = resultReporter.makeReport();

		writer.write(finalResults);

	}

}
