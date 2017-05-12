package com.newt.leavebalance.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newt.leavebalance.model.LeaveBalance;
import com.newt.leavebalance.model.LeaveType;
import com.newt.leavebalance.service.LeaveBalanceService;


@RestController
@RequestMapping("/leavebalance")
public class LeaveBalanceController {
	@Autowired
	LeaveBalanceService leaveBalanceService;
	//public final Logger logger=org.slf4j.LoggerFactory.getLogger(LeaveBalanceController.class);
	@RequestMapping(method= RequestMethod.GET,value="/get",produces = "application/json")
	public List<LeaveBalance> getAllLeaveBalance(){
		List<LeaveBalance> leavelist=leaveBalanceService.getAllLeaveBalance();
		
		return leavelist;
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/add",produces = "application/json")
	public LeaveBalance addLeaveBalance(@RequestBody LeaveBalance leaveBalance){
		
		return leaveBalanceService.addLeaveBalance(leaveBalance);
		
	}
	@RequestMapping(method=RequestMethod.GET, value="/get/leavebalId/{leaveBalId}",produces = "application/json")
	public  LeaveBalance getLeaveBalanceByLeaveBalId(@PathVariable("leaveBalId")int id){
		
		return leaveBalanceService.getLeaveBalanceByLeaveBalId(id);
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT,produces = "application/json")
	public LeaveBalance updateleaveBalance(LeaveBalance leaveBalance){
		
		return leaveBalanceService.updateLeaveBalance(leaveBalance);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{leaveBalId}",produces = "application/json")
	public void deleteLeaveBalance(@PathVariable("leaveBalId")int leaveBalId){
		
		leaveBalanceService.deleteLeaveBalance(leaveBalId);
		
	}
	@RequestMapping(method=RequestMethod.GET, value="/get/byempId/{empId}",produces = "application/json")
	public  List<LeaveBalance> getLeaveBalanceByEmpId(@PathVariable("empId")String id){
		
		List<LeaveBalance> leaveb= leaveBalanceService.getLeaveBalanceByEmpId(id);
		
		return leaveb;
	}
     /*@RequestMapping(method=RequestMethod.GET, value="/get/leavetype/{leaveTypeId}",produces = "application/json")
		public  LeaveType getLeaveTypeByLeaveTypeId(@PathVariable("leaveTypeId")int id){
			
			return leaveBalanceService.getLeaveTypeByLeaveTypeId(id);
			
		}*/
		
		
		
		
	}


