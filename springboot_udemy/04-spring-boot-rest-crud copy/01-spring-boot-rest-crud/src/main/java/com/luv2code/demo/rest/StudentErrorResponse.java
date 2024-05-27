package com.luv2code.demo.rest;

public class StudentErrorResponse {
    private int status;
    private String errormessage;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, long timeStamp, String errormessage) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.errormessage = errormessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
