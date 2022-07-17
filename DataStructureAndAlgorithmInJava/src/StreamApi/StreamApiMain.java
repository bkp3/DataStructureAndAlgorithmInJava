package StreamApi;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApiMain {

	static List<Employee> employees = new ArrayList<>();
	static {
		Employee emp1 = new Employee("Rakesh", "Kumar", 50000.0, List.of("java", "Android", "spring boot"));
		Employee emp2 = new Employee("Suresh", "Kumar", 25000.0, List.of("aws", "vue", "react"));
		Employee emp3 = new Employee("Mahesh", "Kumar", 75000.0, List.of("kafka", "system design", "rest api"));
		Employee emp4 = new Employee("Ankit", "Kumar", 36000.0, List.of("sql", "microservices", "jpa"));
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);

	}

	public static void main(String[] args) {

		// foreach
		employees.stream().forEach(x -> System.out.println(x));

		System.out.println("---------------------------------------------");

		// map
		// collect
		List<Employee> increasedSal = employees.stream()
				.map(x -> new Employee(x.getFirstName(), x.getLastName(), x.getSalary() * 1.10, x.getProjects()))
				.collect(Collectors.toList());

		System.out.println(increasedSal);
		System.out.println("---------------------------------------------");

		// filter
		// filter the employee whose salary is greater than 40000

		List<Employee> filteredList = employees
				.stream().filter(x -> x.getSalary() > 40000.0).map(emploee -> new Employee(emploee.getFirstName(),
						emploee.getLastName(), emploee.getSalary(), emploee.getProjects()))
				.collect(Collectors.toList());
		System.out.println(filteredList);

		System.out.println("----------------------------------------------");

		// filter
		// findfirst

		Employee firstEmployee = employees.stream().filter(x -> x.getSalary() > 40000.0)
				.map(emploee -> new Employee(emploee.getFirstName(), emploee.getLastName(), emploee.getSalary(),
						emploee.getProjects()))
				.findFirst().orElse(null);
		System.out.println(firstEmployee);
		System.out.println("--------------------------------------------------------");

		// flatmap
		String projects = employees.stream().map(x -> x.getProjects()).flatMap(strings -> strings.stream())
				.collect(Collectors.joining(","));
		System.out.println(projects);
		System.out.println("----------------------------------------------------------");

	}

}
