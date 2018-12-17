package com.nic.upjn.miscellaneous;
public class UtillException extends Exception {


    private String errorMessage;
    public UtillException(String msg) {
            this.errorMessage = msg;
   }

    public String getMessage(){
        return this.errorMessage;
    }
    
    public String toString(){
         return errorMessage;
    }
}