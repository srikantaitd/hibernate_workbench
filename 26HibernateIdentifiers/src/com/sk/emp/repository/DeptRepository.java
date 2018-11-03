package com.sk.emp.repository;

import com.sk.emp.domain.id.increment.Dept;

public interface DeptRepository {

	public void saveDept(com.sk.emp.domain.id.increment.Dept deptObject);

	public void saveDept(com.sk.emp.domain.id.sequence.Dept deptObject);
	
	public void saveDept(com.sk.emp.domain.id.sequence.hilow.Dept deptObject);
	public void saveDept(com.sk.emp.domain.id.table.hilow.Dept deptObject);

}
