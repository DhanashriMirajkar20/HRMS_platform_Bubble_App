package com.example.time.controller;

import com.example.EmployeeManagement.Model.Employee;
<<<<<<< HEAD
import com.example.time.dto.LeaveRequestDTO;
import com.example.time.entity.LeaveRequest;
import com.example.time.mapper.LeaveRequestMapper;
=======
import com.example.time.dto.LeaveBalanceDTO;
import com.example.time.dto.LeaveRequestDTO;
import com.example.time.entity.LeaveBalance;
import com.example.time.entity.LeaveRequest;
import com.example.time.entity.LeaveType;
import com.example.time.mapper.LeaveRequestMapper;
import com.example.time.repository.LeaveBalanceRepository;
import com.example.time.repository.LeaveTypeRepository;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import com.example.time.services.LeaveService;
import com.example.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
@RestController
@RequestMapping("/api/v1/hrms/time/leaves")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;
    private final SecurityUtil securityUtil;
<<<<<<< HEAD
=======
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final LeaveTypeRepository leaveTypeRepository;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

    /**
     * APPLY LEAVE
     * Employee can apply ONLY for self
     */
    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping("/apply")
    public LeaveRequestDTO applyLeave(@RequestBody LeaveRequestDTO dto) {

        // Logged-in employee (SAFE)
        Employee employee = securityUtil.getLoggedInEmployee();

        LeaveRequest entity = LeaveRequestMapper.toEntity(dto, employee);
        LeaveRequest saved = leaveService.applyLeave(entity);

        return LeaveRequestMapper.toDTO(saved);
    }

    /**
<<<<<<< HEAD
     * APPROVE LEAVE
     * ONLY employee's CURRENT MANAGER can approve
     */
    @PreAuthorize("hasRole('EMPLOYEE')")
    @PutMapping("/{leaveRequestId}/approve")
    public LeaveRequestDTO approveLeave(@PathVariable Long leaveRequestId) {

        Employee approver = securityUtil.getLoggedInEmployee();

        LeaveRequest approved =
                leaveService.approveLeave(leaveRequestId, approver.getEmployeeId());
=======
     * GET logged-in employee leave balances
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/balances/me")
    public List<LeaveBalanceDTO> getLeaveBalancesForMe() {
        Employee employee = securityUtil.getLoggedInEmployee();
        List<LeaveBalance> balances = leaveBalanceRepository.findByEmployee(employee);
        Map<Long, LeaveBalance> balanceByType = balances.stream()
                .filter(balance -> balance.getLeaveTypeId() != null)
                .collect(Collectors.toMap(LeaveBalance::getLeaveTypeId, balance -> balance, (a, b) -> a));

        List<LeaveType> leaveTypes = leaveTypeRepository.findAll();
        if (leaveTypes.isEmpty()) {
            return balances.stream()
                    .map(balance -> mapToLeaveBalanceDto(null, balance))
                    .toList();
        }

        return leaveTypes.stream()
                .map(type -> mapToLeaveBalanceDto(type, balanceByType.get(type.getLeaveTypeId())))
                .toList();
    }

    /**
     * APPROVE LEAVE
     * ONLY employee's CURRENT MANAGER can approve
     */
    @PreAuthorize("hasAnyRole('EMPLOYEE','HR_MANAGER','HR','HR_OPERATIONS','HR_BP','HR_PAYROLL','TALENT_ACQUISITION','ADMIN')")
    @PutMapping("/{leaveRequestId}/approve")
    public LeaveRequestDTO approveLeave(@PathVariable Long leaveRequestId) {

        Employee approver = securityUtil.getLoggedInEmployeeOptional().orElse(null);
        LeaveRequest approved;

        if (securityUtil.hasRole("HR_MANAGER") ||
                securityUtil.hasRole("HR") ||
                securityUtil.hasRole("HR_OPERATIONS") ||
                securityUtil.hasRole("HR_BP") ||
                securityUtil.hasRole("HR_PAYROLL") ||
                securityUtil.hasRole("TALENT_ACQUISITION") ||
                securityUtil.hasRole("ADMIN")) {
            Long approverId = securityUtil.getApproverIdFallbackToUser();
            approved = leaveService.approveLeaveAsHr(leaveRequestId, approverId);
        } else {
            approved = leaveService.approveLeave(leaveRequestId, approver.getEmployeeId());
        }
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

        return LeaveRequestMapper.toDTO(approved);
    }

    /**
     * REJECT LEAVE
     * ONLY employee's CURRENT MANAGER can reject
     */
<<<<<<< HEAD
    @PreAuthorize("hasRole('EMPLOYEE')")
    @PutMapping("/{leaveRequestId}/reject")
    public LeaveRequestDTO rejectLeave(@PathVariable Long leaveRequestId) {

        Employee approver = securityUtil.getLoggedInEmployee();

        LeaveRequest rejected =
                leaveService.rejectLeave(leaveRequestId, approver.getEmployeeId());

        return LeaveRequestMapper.toDTO(rejected);
    }
=======
    @PreAuthorize("hasAnyRole('EMPLOYEE','HR_MANAGER','HR','HR_OPERATIONS','HR_BP','HR_PAYROLL','TALENT_ACQUISITION','ADMIN')")
    @PutMapping("/{leaveRequestId}/reject")
    public LeaveRequestDTO rejectLeave(@PathVariable Long leaveRequestId) {

        Employee approver = securityUtil.getLoggedInEmployeeOptional().orElse(null);
        LeaveRequest rejected;

        if (securityUtil.hasRole("HR_MANAGER") ||
                securityUtil.hasRole("HR") ||
                securityUtil.hasRole("HR_OPERATIONS") ||
                securityUtil.hasRole("HR_BP") ||
                securityUtil.hasRole("HR_PAYROLL") ||
                securityUtil.hasRole("TALENT_ACQUISITION") ||
                securityUtil.hasRole("ADMIN")) {
            Long approverId = securityUtil.getApproverIdFallbackToUser();
            rejected = leaveService.rejectLeaveAsHr(leaveRequestId, approverId);
        } else {
            rejected = leaveService.rejectLeave(leaveRequestId, approver.getEmployeeId());
        }

        return LeaveRequestMapper.toDTO(rejected);
    }

    /**
     * View pending leave requests for current manager
     */
    @PreAuthorize("hasAnyRole('EMPLOYEE','HR_MANAGER','HR','HR_OPERATIONS','HR_BP','HR_PAYROLL','TALENT_ACQUISITION','ADMIN')")
    @GetMapping("/pending")
    public List<LeaveRequestDTO> pendingForManager() {
        if (securityUtil.hasRole("ADMIN")) {
            return leaveService.getPendingAll()
                    .stream()
                    .map(LeaveRequestMapper::toDTO)
                    .toList();
        }

        Employee approver = securityUtil.getLoggedInEmployeeOptional().orElse(null);
        if (securityUtil.hasRole("HR_MANAGER")) {
            String dept = approver != null ? approver.getDepartment() : null;
            return leaveService.getPendingHrByDepartment(dept)
                    .stream()
                    .map(LeaveRequestMapper::toDTO)
                    .toList();
        }

        if (securityUtil.hasRole("HR") ||
                securityUtil.hasRole("HR_OPERATIONS") ||
                securityUtil.hasRole("HR_BP") ||
                securityUtil.hasRole("HR_PAYROLL") ||
                securityUtil.hasRole("TALENT_ACQUISITION")) {
            return leaveService.getPendingNonHr()
                    .stream()
                    .map(LeaveRequestMapper::toDTO)
                    .toList();
        }

        return leaveService.getPendingForManager(approver.getEmployeeId())
                .stream()
                .map(LeaveRequestMapper::toDTO)
                .toList();
    }

    private LeaveBalanceDTO mapToLeaveBalanceDto(LeaveType type, LeaveBalance balance) {
        Long leaveTypeId = type != null ? type.getLeaveTypeId() : balance != null ? balance.getLeaveTypeId() : null;
        String leaveTypeName =
                type != null ? type.getLeaveName() : leaveTypeId != null ? "Leave Type " + leaveTypeId : "Leave";
        Integer totalLeaves = balance != null ? balance.getTotalLeaves() : null;
        Integer usedLeaves = balance != null ? balance.getUsedLeaves() : 0;
        Integer remainingLeaves = balance != null ? balance.getRemainingLeaves() : null;
        Integer maxPerYear = type != null ? type.getMaxPerYear() : null;
        Boolean carryForwardAllowed = type != null ? type.getCarryForwardAllowed() : null;

        if (totalLeaves == null && maxPerYear != null) {
            totalLeaves = maxPerYear;
        }
        if (usedLeaves == null) {
            usedLeaves = 0;
        }
        if (remainingLeaves == null && totalLeaves != null) {
            remainingLeaves = Math.max(0, totalLeaves - usedLeaves);
        }

        return new LeaveBalanceDTO(
                leaveTypeId,
                leaveTypeName,
                totalLeaves,
                usedLeaves,
                remainingLeaves,
                maxPerYear,
                carryForwardAllowed
        );
    }
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
