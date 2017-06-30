package module1;

import java.util.Arrays;

/*Procedure - object representation of the user commands*/
public class Procedure {
	private String Name;
	private String Parameter;
	private Integer Timeout;

	public Procedure(String[] array) {
		
		switch (array.length) {
		case 2:
			this.Name = array[0];
			this.Parameter = array[1];
			break;
		case 3:
			this.Name = array[0];
			this.Parameter = array[1];
			try {
				Timeout = (Integer.parseInt(array[2])) * 1000;
			} catch (NumberFormatException e) {
				System.out.println("Invalid third parameter " + Arrays.deepToString(array) + ".");
				System.exit(-1);
			}
			break;
		default:
			System.out.println("You've specified invalid amount of parameters or left empty line " + Arrays.deepToString(array));
			System.out.println(
					"Notice: System not supports using nested Quotation marks (\"\") inside parameters e.g. \"par\"am\"eter\"");
			System.exit(-1);
			break;
		}
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getParameter() {
		return Parameter;
	}

	public void setParameter(String parameter) {
		Parameter = parameter;
	}

	public Integer getTimeout() {
		return Timeout;
	}

	public void setTimeout(Integer timeout) {
		Timeout = timeout;
	}

	@Override
	public String toString() {
		return "Procedure [Name=" + Name + ", Parameter=" + Parameter + ", Timeout=" + Timeout + "]";
	}
}
