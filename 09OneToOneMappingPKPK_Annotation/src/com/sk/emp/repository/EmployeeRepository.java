package com.sk.emp.repository;

import com.sk.emp.domain.Employee;

public interface EmployeeRepository {

	public void saveEmployee(Employee empObject);

	public void updateEmployee(Employee newEmpObject);

	public Employee getEmployee(int empID);

	public void deleteEmployee(int empID);

}
