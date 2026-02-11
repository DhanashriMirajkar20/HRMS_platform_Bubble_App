package com.example.EmployeeManagement.Exception.Handler;


<<<<<<< HEAD
import com.example.EmployeeManagement.DTO.ApiDto;
import com.example.EmployeeManagement.Exception.*;
=======
import java.time.LocalDateTime;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
import com.example.EmployeeManagement.DTO.ApiDto;
import com.example.EmployeeManagement.Exception.DataNotFoundException;
import com.example.EmployeeManagement.Exception.EmployeeEducationNotFoundException;
import com.example.EmployeeManagement.Exception.EmployeeNotFoundException;
import com.example.EmployeeManagement.Exception.EmployeePersonalExistsException;
import com.example.EmployeeManagement.Exception.EmployeePersonalNotFoundException;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiDto> handleEmployeeNotFound(EmployeeNotFoundException ex){
        ApiDto error = new ApiDto(
          404,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmployeePersonalNotFoundException.class)
    public ResponseEntity<ApiDto> handleEmployeePersonalNotFound(EmployeePersonalNotFoundException ex){
        ApiDto error = new ApiDto(
                404,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmployeePersonalExistsException.class)
    public ResponseEntity<ApiDto> handleEmployeePersonalExistsException(EmployeePersonalExistsException ex){
        ApiDto error = new ApiDto(
                409,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(EmployeeEducationNotFoundException.class)
    public ResponseEntity<ApiDto> handleEmployeeEducationNotExist(EmployeeEducationNotFoundException ex){
        ApiDto error = new ApiDto(
                404,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ApiDto> handleDataNotFoundException(DataNotFoundException ex){
        ApiDto error = new ApiDto(
                404,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
<<<<<<< HEAD
=======

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiDto> handleIllegalArgument(IllegalArgumentException ex) {
        ApiDto error = new ApiDto(
                400,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
