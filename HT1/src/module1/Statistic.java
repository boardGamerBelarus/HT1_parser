package module1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/*Statistic - responsible for gathering and calculating statistics*/
public class Statistic {

	private static double startingTotalTime;
	private static double endingTotalTime;
	private static int passedTestsAmount;
	private static int failedTestsAmount;
	private static ArrayList<Double> operationTimeList = new ArrayList<Double>();
	private static Long operationTime = (long) 0;
	private static Double operationTimeDouble = 0.0;
	private static Double roundedOperationTime = 0.0;
	private static Long currentTime = (long) 0;

	public static void startTotalTime() {

		startingTotalTime = System.currentTimeMillis();

	}

	public static String getTotalTime() {
		double result;
		double roundedResult;
		endingTotalTime = System.currentTimeMillis();

		result = endingTotalTime - startingTotalTime;
		result = (result / 1000);
		roundedResult = new BigDecimal(result).setScale(3, RoundingMode.UP).doubleValue();
		return "Total time: " + roundedResult;
	}

	public static void getOperationTime() {
		if (operationTime == 0) {
			operationTime = System.currentTimeMillis();

		} else {
			currentTime = System.currentTimeMillis();

			operationTime = currentTime - operationTime;
			operationTimeDouble = operationTime.doubleValue();

			operationTimeDouble = (operationTimeDouble / 1000);
			roundedOperationTime = new BigDecimal(operationTimeDouble).setScale(3, RoundingMode.UP).doubleValue();

			operationTimeList.add(roundedOperationTime);

			operationTime = currentTime;

		}

	}

	public static String getAverageTime() {

		Double totalSum = 0.0;
		Double count = 0.0;
		Double roundedTotalSum = 0.0;
		if (!operationTimeList.isEmpty()) {
			for (Double time : operationTimeList) {
				totalSum = totalSum + time;
				count++;
			}
			totalSum = totalSum / count;
			roundedTotalSum = new BigDecimal(totalSum).setScale(3, RoundingMode.UP).doubleValue();
		}
		return "Average time: " + roundedTotalSum;

	}

	public static String getTestsAmount() {
		return "Total tests: " + (passedTestsAmount + failedTestsAmount);
	}

	public static void incrementAmountOfPassedTests() {
		passedTestsAmount = passedTestsAmount + 1;
	}

	public static void incrementAmountOfFailedTests() {
		failedTestsAmount = failedTestsAmount + 1;
	}

	public static String getPassedFailedStatistic() {
		return "Passed/Failed: " + passedTestsAmount + "/" + failedTestsAmount;
	}

	public static ArrayList<Double> getOperationTimeList() {
		return operationTimeList;
	}
}
