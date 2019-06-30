package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel workerLevel;
	private Double baseSalary;
	
	private Departament departament;
	
	private List<HourContract> contracts= new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel workerLevel, Double baseSalary, Departament departament) {
		super();
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}
	
	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}
	public List<HourContract> getContracts() {
		return contracts;
	}
	

	public Double getBaseSalary() {
		return baseSalary;
	}
	public void addContract(HourContract contract) {
		
		contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		
		
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			
			if(c_year == year && c_month == month) {
				sum += c.totalValue();
			}
		}
		
		return sum;
	}
	
	
}
