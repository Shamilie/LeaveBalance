package com.newt.leavebalance.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newt.leavebalance.model.LeaveBalance;
import com.newt.leavebalance.model.LeaveType;
import com.newt.leavebalance.repository.LeaveBalanceRepository;

@Service("LeaveBalanceImpl")
public class LeaveBalanceImpl implements LeaveBalanceService{
	@Autowired
	LeaveBalanceRepository leaveBalanceRepository;


	@Override
	public List<LeaveBalance> getAllLeaveBalance() {
		return leaveBalanceRepository.findAll();
	}

	@Override
	public LeaveBalance addLeaveBalance(LeaveBalance leavebalance) {
		return leaveBalanceRepository.save(leavebalance);
		
	}

	

	@Override
	public LeaveBalance updateLeaveBalance(LeaveBalance leavebalance) {
		return leaveBalanceRepository.save(leavebalance);
	}

	@Override
	public void deleteLeaveBalance(int leaveBalId) {
		leaveBalanceRepository.deleteByLeaveBalId(leaveBalId);
	}

	@Override
	public LeaveBalance getLeaveBalanceByLeaveBalId(int leaveBalId) {
		return leaveBalanceRepository.findOne(leaveBalId);
	}

	@Override
	public List<LeaveBalance> getLeaveBalanceByEmpId(String empId) {
		List <LeaveBalance> leavebal=  leaveBalanceRepository.findByEmpId(empId);
		Iterator<LeaveBalance> it=leavebal.iterator();
		int leaveTypeId;
		 String leavetype;
		while(it.hasNext()){
			LeaveBalance l=it.next();
		 leaveTypeId=l.getLeaveTypeId();
		  leavetype=leaveBalanceRepository.findByLeaveTypeId(leaveTypeId);
		  l.setLeaveType(leavetype);
		}
		
		return leavebal;
		
	}

	/*@Override
	public LeaveType getLeaveTypeByLeaveTypeId(int leaveTypeId) {
		
		return leaveBalanceRepository.findByLeaveTypeId(leaveTypeId);
	}*/
		
}
