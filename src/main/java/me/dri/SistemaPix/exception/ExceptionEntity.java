package me.dri.SistemaPix.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionEntity  implements Serializable {

    private Date timestamp;
    private String message;
    private String details;
    private int errorstatus;
    
    public ExceptionEntity() {

    }

    public ExceptionEntity(Date timestamp, String message, String details, int errorstatus) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.errorstatus = errorstatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(int errorstatus) {
        this.errorstatus = errorstatus;
    }

    

    
}
