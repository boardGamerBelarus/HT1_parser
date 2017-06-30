package module1;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*JsoupExecutor - uses Jsoup framework for getting data from a web page*/
public class JsoupExecutor {
	Document doc;
	static String TEST_PASSED = "+ ";
	static String TEST_FAILED = "! ";

	public String open(String URL, Integer integer) {

		try {
			doc = Jsoup.connect(URL).timeout(integer).get();
			Statistic.incrementAmountOfPassedTests();
			return TEST_PASSED;
		} catch (IOException e) {
			Statistic.incrementAmountOfFailedTests();
			return TEST_FAILED;
		} catch (IllegalArgumentException e) {
		
			Statistic.incrementAmountOfFailedTests();
			return TEST_FAILED;
		}

	}

	public String checkPageTitle(String ExpectedTitle) {

		String Actualtitle = doc.title();
		if (Actualtitle.equals(ExpectedTitle)) {
			Statistic.incrementAmountOfPassedTests();
			return TEST_PASSED;
		} else {
			Statistic.incrementAmountOfFailedTests();
			return TEST_FAILED;
		}
	}

	public String checkLinkPresentByHref(String ExpectedHref) {

		Elements links = doc.select("a[href=" + ExpectedHref + "]");
		if (!links.isEmpty()) {
			Statistic.incrementAmountOfPassedTests();
			return TEST_PASSED;
		} else {
			Statistic.incrementAmountOfFailedTests();
			return TEST_FAILED;
		}
	}

	public String checkLinkPresentByName(String ExpectedName) {

		Elements links = doc.select("a:contains(" + ExpectedName + ")");
		if (!links.isEmpty()) {
			Statistic.incrementAmountOfPassedTests();
			return TEST_PASSED;
		} else {
			Statistic.incrementAmountOfFailedTests();
			return TEST_FAILED;
		}
	}

	public String checkPageContains(String ExpectedText) {

		Elements links = doc.select("html:contains(" + ExpectedText + ")");
		if (!links.isEmpty()) {
			Statistic.incrementAmountOfPassedTests();
			return TEST_PASSED;
		} else {
			Statistic.incrementAmountOfFailedTests();
			return TEST_FAILED;
		}
	}

	public String pageIsNotOpened(String commandName, String commandParameter, Integer timeout) {
		
		Statistic.incrementAmountOfFailedTests();
		
		System.out.println("Unable to perform \""+ commandName +"\" command. Page is not opened because Timeout is invalid or too low: "+timeout);

		return TEST_FAILED;
	}

}
