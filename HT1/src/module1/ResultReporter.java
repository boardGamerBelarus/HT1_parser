package module1;

import java.util.ArrayList;

//ResultReporter - displays log into console and organizes Report List that is used by Writer
public class ResultReporter {

	ArrayList<String> commands;
	ArrayList<String> performingResults;
	ArrayList<String> finalResults;
	private ArrayList<Double> operationTimeList;

	public ResultReporter(ArrayList<String> commands, ArrayList<String> performingResults) {
		this.commands = commands;
		this.performingResults = performingResults;
		this.operationTimeList = Statistic.getOperationTimeList();
	}

	public ArrayList<String> makeReport() {
		int count = 0;
		finalResults = new ArrayList<>();

		try {
			for (String command : commands) {
				System.out.println(performingResults.get(count) + "[" + command + "] " + operationTimeList.get(count));
				finalResults.add(performingResults.get(count) + "[" + command + "] "+ operationTimeList.get(count));
				count++;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Synchronization between commands and results is broken");
		}

		System.out.println(Statistic.getTestsAmount());
		System.out.println(Statistic.getPassedFailedStatistic());
		System.out.println(Statistic.getTotalTime());
		System.out.println(Statistic.getAverageTime());
		
		finalResults.add(Statistic.getTestsAmount());
		finalResults.add(Statistic.getPassedFailedStatistic());
		finalResults.add(Statistic.getTotalTime());
		finalResults.add(Statistic.getAverageTime());
		return finalResults;
	}
}
