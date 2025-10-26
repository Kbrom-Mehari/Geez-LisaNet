package org.kbapps.geez_lisanet.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private int status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private Map<String,String> errors;

    public  ErrorResponse(int status, String message, String error, LocalDateTime timestamp,Map<String,String> errors){
        this.status=status;
        this.message=message;
        this.error=error;
        this.timestamp=timestamp;
        this.errors=errors;
    }
    public  ErrorResponse(int status, String message, String error, LocalDateTime timestamp){
        this.status=status;
        this.message=message;
        this.error=error;
        this.timestamp=timestamp;
    }
}


