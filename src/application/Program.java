package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String dep = sc.nextLine();
		Departament departament = new Departament(dep);
		System.out.print("Enter work data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.next();
		System.out.print("Base Salary: ");
		double salary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, 
				new Departament(dep));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			System.out.println("Enter contract #"+i+"data");
			System.out.print("Date (DD/MM/YYYY)");
			Date dateContract = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double value = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int d = sc.nextInt();
			
			HourContract contract = new HourContract(dateContract,value, d);
			worker.addContract(contract);
			
		}
		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+worker.getName());
		
		System.out.println("Departament: "+worker.getDepartament().getName());

		System.out.println("Income for "+monthAndYear+" : "+String.format("%.2f",worker.income(year, month)));
		
	}

}
