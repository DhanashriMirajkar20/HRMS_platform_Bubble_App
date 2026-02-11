package com.example.time.services;

import com.example.time.entity.LeaveRequest;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

public interface LeaveService {
    LeaveRequest applyLeave(LeaveRequest request);
    LeaveRequest approveLeave(Long leaveRequestId, Long approverId);
    LeaveRequest rejectLeave(Long leaveRequestId, Long approverId);
<<<<<<< HEAD
=======
    LeaveRequest approveLeaveAsHr(Long leaveRequestId, Long approverId);
    LeaveRequest rejectLeaveAsHr(Long leaveRequestId, Long approverId);
    List<LeaveRequest> getPendingForManager(Long managerId);
    List<LeaveRequest> getPendingAll();
    List<LeaveRequest> getPendingHrByDepartment(String department);
    List<LeaveRequest> getPendingNonHr();
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
