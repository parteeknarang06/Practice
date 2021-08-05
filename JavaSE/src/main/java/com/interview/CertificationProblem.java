package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CertificationProblem {

	public static void main(String[] args) {
		List<Certification> certifications = new ArrayList<Certification>(3) {
			private static final long serialVersionUID = -7624935832838546486L;
			{
				add(new Certification(1, "Java"));
				add(new Certification(2, ".net"));
				add(new Certification(3, "Nodejs"));
			}
		};
		List<Employee> employees = new ArrayList<Employee>(20) {
			private static final long serialVersionUID = -2099194376969504924L;
			{
				add(new Employee(101, "emp1", "Java", 1));
				add(new Employee(102, "emp2", "Java", 1));
				add(new Employee(103, "emp3", "Java", 1));
				add(new Employee(104, "emp4", "Java", 1));
				add(new Employee(105, "emp5", ".net", 2));
				add(new Employee(106, "emp6", ".net", 2));
				add(new Employee(107, "emp7", ".net", 2));
				add(new Employee(108, "emp8", "Nodejs", 3));
				add(new Employee(109, "emp9", "Nodejs", 3));
				add(new Employee(110, "emp10", "Nodejs", 3));
				add(new Employee(111, "emp11", "Java", 0));
				add(new Employee(112, "emp12", "Java", 2));
				add(new Employee(113, "emp13", "Java", 3));
				add(new Employee(114, "emp14", "Java", 2));
				add(new Employee(115, "emp15", ".net", 0));
				add(new Employee(116, "emp16", ".net", 0));
				add(new Employee(117, "emp17", ".net", 2));
				add(new Employee(118, "emp18", "Nodejs", 0));
				add(new Employee(119, "emp19", "Nodejs", 2));
				add(new Employee(120, "emp20", "Nodejs", 2));

			}
		};

		System.out.println("Empid\tEmpName\tTechStack\tCertificationId");
		employees.stream().forEach(element -> {
			System.out.println(element.getEmpId() + "\t" + element.getFname() + "\t" + element.getTechPlatform() + "\t\t"
					+ element.getCertificationId());
		});

		System.out.println("\nCertificationId\tTechName");
		certifications.stream().forEach(element -> {
			System.out.println(element.getCertificationId() + "\t\t" + element.getTechPlatform());
		});

		System.out.println("\nfiltered data");

		employees.stream().filter(getPredicate(certifications)).forEach(element -> {
			System.out.println(element.getEmpId() + "\t" + element.getFname() + "\t" + element.getTechPlatform() + "\t\t"
					+ element.getCertificationId());
		});

		Map<String, List<Employee>> collect = employees.stream().filter(getPredicate(certifications))
				.collect(Collectors.groupingBy(Employee::getTechPlatform));
		collect.forEach((tech, emps) -> {
			System.out.println("techname:" + tech + " emps:" + emps.size());
		});
	}

	private static Predicate<Employee> getPredicate(List<Certification> certifications) {
		Predicate<Employee> pred = new Predicate<Employee>() {
			@Override
			public boolean test(Employee source) {
				return !certifications.stream()
						.anyMatch(element -> source.getCertificationId() == element.getCertificationId()
								&& source.getTechPlatform() == element.getTechPlatform());
			}
		};
		return pred;
	}
}
