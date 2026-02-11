package com.example.time.services;


import java.util.List;

public interface AttendanceService {
<<<<<<< HEAD
    com.example.time.entity.Attendance checkIn(long employeeId);
    com.example.time.entity.Attendance checkOut(long employeeId);
=======
    com.example.time.entity.Attendance checkIn(long employeeId, String source, Double latitude, Double longitude, String ipAddress);
    com.example.time.entity.Attendance checkOut(long employeeId, String source, Double latitude, Double longitude, String ipAddress);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

    List<com.example.time.entity.Attendance> getEmployeeAttendance(long employeeId);

}
