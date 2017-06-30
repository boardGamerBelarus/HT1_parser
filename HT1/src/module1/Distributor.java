package module1;

import java.util.ArrayList;
import java.util.Iterator;

/*Distributor - gets List of Procedures from Collector and calls methods 
from JsoupExecutor according to Procedure name*/
public class Distributor {
	Iterator<Procedure> iterator;
	JsoupExecutor execution;

	ArrayList<String> performResultList;

	public ArrayList<String> distribute(ArrayList<Procedure> arrayList) {

		iterator = arrayList.iterator();
		performResultList = new ArrayList<String>();

		while (iterator.hasNext()) {
			Statistic.getOperationTime();
			Procedure procedure = iterator.next();

			try {
				switch (procedure.getName()) {
				case "open":
					execution = new JsoupExecutor();
					performResultList.add(execution.open(procedure.getParameter(), procedure.getTimeout()));
					break;
				case "checkLinkPresentByHref":
					performResultList.add(execution.checkLinkPresentByHref(procedure.getParameter()));
					break;
				case "checkLinkPresentByName":
					performResultList.add(execution.checkLinkPresentByName(procedure.getParameter()));
					break;
				case "checkPageTitle":
					performResultList.add(execution.checkPageTitle(procedure.getParameter()));
					break;
				case "checkPageContains":
					performResultList.add(execution.checkPageContains(procedure.getParameter()));
					break;
				default:
					Statistic.incrementAmountOfFailedTests();
					System.out.println("Command \"" + procedure.getName() + "\" is unknown");
					performResultList.add(JsoupExecutor.TEST_FAILED);
					break;
				}
			} catch (NullPointerException e) {

				if (execution != null) {
					performResultList.add(execution.pageIsNotOpened(procedure.getName(), procedure.getParameter(),
							procedure.getTimeout()));
				} else {
					System.out.println("Unable to perform \"" + procedure.getName() + "\" command. Page is not opened");
					Statistic.incrementAmountOfFailedTests();
					performResultList.add(JsoupExecutor.TEST_FAILED);
				}

			}

		}
		Statistic.getOperationTime();
		return performResultList;
	}

}
