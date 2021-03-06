package com.newt.leavebalance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.newt.leavebalance.model.LeaveBalance;
import com.newt.leavebalance.model.LeaveType;



public interface LeaveBalanceService {
	 public List<LeaveBalance> getAllLeaveBalance() ;
	 public LeaveBalance addLeaveBalance(LeaveBalance leavebalance);
	 
	
	 public LeaveBalance updateLeaveBalance(LeaveBalance leavebalance);
	 public void deleteLeaveBalance(int leaveBalId);
	public LeaveBalance getLeaveBalanceByLeaveBalId(int leaveBalId);
public List<LeaveBalance> getLeaveBalanceByEmpId(String empId);


/*public LeaveType getLeaveTypeByLeaveTypeId(int leaveTypeId);*/

}
