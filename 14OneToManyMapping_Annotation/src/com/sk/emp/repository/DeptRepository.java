package com.sk.emp.repository;

import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;

public interface DeptRepository {

	public void saveDept(Dept deptObject);

	public void updateDept(Dept deptObject);

	public Dept getDept(int deptID);

	public void deleteDept(int deptID);

}
