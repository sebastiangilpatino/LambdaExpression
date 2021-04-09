package LmbdaHW;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaHomework {

	public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"), new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), new Employee("Wendy", "Brown", 4236.4, "Marketing") };

		// get List view of the Employees
		List<Employee> list = Arrays.asList(employees);

		// display all Employees
		System.out.println("Complete Employee list:");
		list.stream().forEach(System.out::println); // A method reference.

		/*
		 * 1)
		 */
		System.out.println("\nCount the number of last names that begin with the letter ‘B’");
		System.out.println(list.stream().map(e -> e.getLastName()).filter(x -> x.startsWith("B")).count());

		/*
		 * 2)
		 */

		System.out.println(
				"\nPrint out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.");
		Comparator<Employee> compareByName = Comparator.comparing(Employee::getFirstName);
		list.stream().filter(e -> e.getLastName().startsWith("B")).sorted(compareByName).forEach(System.out::println);

		/*
		 * 3)
		 */

		System.out.println("\nPrint out all of the Employee objects whose last name begins with the letter  ‘B’  "
				+ "and change\n their first name and last name to be All capital letters.");

		list.stream().filter(e -> e.getLastName().startsWith("B")).forEach(x -> {
			if (x.getLastName().startsWith("B")) {
				System.out.println(x.getName().toUpperCase());
			} else {
				System.out.println(x.getName());
			}
		});

		/*
		 * 3.1) using clone
		 */

		System.out.println("\nV2 Cloning");

		list.stream().map(x -> {
			Employee emp = null;

			try {
				emp = (Employee) x.clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (emp.getLastName().startsWith("B")) {
				emp.setLastName(emp.getLastName().toUpperCase());
				emp.setFirstName(emp.getFirstName().toUpperCase());
			}
			return emp;
		}).filter(x -> x.getLastName().startsWith("B")).forEach(System.out::println);

		/*
		 * 4)
		 */
		System.out.println("\nPrint out All of the employee objects, but if the last name begins with the letter  ‘B’, "
				+ " then \ncapitalize all the letters in the last name. ");

		list.stream().forEach(x -> {
			if (x.getLastName().startsWith("B")) {
				System.out.println(x.getFirstName() + " " + x.getLastName().toUpperCase());
			} else {
				System.out.println(x.getName());
			}
		});

		/*
		 * 4.1)
		 */

		System.out.println("\nUse the  Collectors.joining  method to print out All Employee objects.");
		System.out.println(list.stream().map(Employee::toString).collect(Collectors.joining()));

		/*
		 * 4.2)
		 */

		System.out.println("\nUse the  Collectors.joining  method to print out All Employee objects,"
				+ " and separate    each one with a delimeter of  “---\\n---“");
		System.out.println(list.stream().map(Employee::toString).collect(Collectors.joining("---\n---")));

		/*
		 * 5)
		 */

		System.out.println(
				"\nPrint out all of the Employee objects’ last names, whose last name begins with the letter  ‘I’  "
						+ "in sorted order, and \nget rid of all the duplicates.  Print out only the last names.");
		list.stream().filter(e -> e.getLastName().startsWith("I")).sorted(compareByName).map(Employee::getLastName)
				.distinct().forEach(System.out::println);

		/*
		 * 6)
		 */

		System.out.println("\nPrint out the average of all the salaries\n"
				+ list.stream().mapToDouble(Employee::getSalary).average().getAsDouble());

		/*
		 * 7)
		 */

		System.out.println("\nUse the  ‘reduce’  method to print out the total salary of all employees.");
		System.out.println(list.stream().mapToDouble(Employee::getSalary).reduce(0, (x, y) -> x + y));

		/*
		 * 8)
		 */

		System.out.println("\nPrint out only the first names of all the employees");
		list.stream().map(Employee::getFirstName).forEach(System.out::println);

		/*
		 * 9)
		 */

		System.out.println("\nCreate an infinite stream of even numbers and then, eventually"
				+ "\nprint out only the first 20 even numbers from this stream.  ");
		IntStream.iterate(0, i -> i + 2).limit(20).forEach(x -> System.out.print(x + " "));
		System.out.println(" ");

		/*
		 * 10) which counts the number of words in the input list words that have length
		 * equal to len, that contain the character c, and that do not contain the
		 * character d
		 */
		System.out.println("\nImplement  a method with the following signature and return type");
		List<String> words = Arrays.asList("sebas", "maria", "naem", "milton", "jora");
		char c = 'a', d = 'm';
		int len = 4;
		System.out.println(countWords(words, c, d, len));

		/*
		 * 11)
		 */
		System.out.println("\nodd numbers starting in 9");
		IntStream.iterate(9, i -> i + 2).limit(4).forEach(x -> System.out.print(x + " "));

		/*
		 * 12)
		 */
		System.out.println("\n\nUse reduce to concatenate the Strings in the Stream below");
		Stream<String> strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");
		System.out.println(strings.reduce((x, y) -> x.concat(y + " ")).get());

	}

	public static int countWords(List<String> words, char c, char d, int len) {
		return (int) words.stream()
				.filter(s -> s.length() == len && s.contains(String.valueOf(c)) && !s.contains(String.valueOf(d)))
				.count();
	}

}
