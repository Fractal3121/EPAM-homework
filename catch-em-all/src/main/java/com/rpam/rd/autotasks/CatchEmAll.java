package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        }
        catch (FileNotFoundException fnf){
            throw new IllegalArgumentException("Resource is missing", fnf);
        }
        catch (IOException ioe){
            throw new IllegalArgumentException("Resource error", ioe);

        }
        catch (ArithmeticException ar){
            System.err.println("ar");
        }
        catch (NumberFormatException nfe){
            System.err.println("nfe");
        }

    }
}
