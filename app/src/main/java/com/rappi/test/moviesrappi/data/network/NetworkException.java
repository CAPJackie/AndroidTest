package main.java.com.rappi.test.moviesrappi.data.network;

public class NetworkException extends Exception {
    public NetworkException(String message, Throwable e){
        super(message,e);
    }
}