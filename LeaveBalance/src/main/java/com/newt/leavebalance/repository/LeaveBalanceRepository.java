package com.newt.leavebalance.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;






import com.newt.leavebalance.model.LeaveBalance;
import com.newt.leavebalance.model.LeaveType;

@Repository("LeaveBalanceRepository")
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer>{
	public long count() ;
	 public List<LeaveBalance> findAll() ;
	 public void deleteByLeaveBalId(Integer leaveBalId);
	 public LeaveBalance findOne(Integer leaveBalId);
	 public <S extends LeaveBalance> List<S> save(List<S> leavebalance) ;
	 
	 public List<LeaveBalance> findByEmpId (String empId);
	// public List<LeaveBalance> findByLeaveBalId(int leaveBalId);
	 
	 @Query(value="select l.LEAVE_TYPE  from TBL_LEAVE_TYPE l where l.LEAVE_TYPE_ID=?1",nativeQuery=true)
	 public String findByLeaveTypeId(int leaveTypeId);
}
