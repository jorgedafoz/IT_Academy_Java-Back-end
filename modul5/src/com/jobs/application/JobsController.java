package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(EmployeeRepository repository){
        this.repository = repository;
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(manager);
	}

    public void createVolunteer(String name, String address, String phone) throws Exception {
        com.jobs.domain.Volunteer volunteer = new Volunteer(name, address, phone, "position not retributed");
        repository.addMember(volunteer);

    }

	public void payAllEmployeers() {
		List<AbsStaffMember> staffMembers = new ArrayList<>();
		staffMembers = repository.getAllMembers();
		for (AbsStaffMember employee : staffMembers) {
		    employee.pay();
        }
	}

	/*public String getAllEmployees() {
        List<AbsStaffMember> staffMembers = new ArrayList<>();
        String membersList = "";
        for (AbsStaffMember employee : staffMembers) {
            if (employee instanceof Employee) {
                membersList = membersList + employee.getName()
                        + " ................Original Salary:"
                        + ((Employee) employee).getSalaryPerMonth() + " \n";
            }
        } return membersList;
    }*/


    public String getAllEmployees() {

        List<AbsStaffMember> members = new ArrayList<>(); // I create new object List of the type AbsStaffMember;

        members = repository.getAllMembers();

        String membersString = "";

        for (int i=0; i<members.size(); i++) {

            membersString += members.get(i).name + " ,";
            membersString += members.get(i).address + " ,";
            membersString += members.get(i).phone + " ,";
            membersString += members.get(i).totalPaid + " ." + " \n";
        }

        return membersString;

    }
}
