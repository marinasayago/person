package es.uma.mps;

public class NegativeAgeException extends RuntimeException{
    public NegativeAgeException(String error){
        super(error);
    }
}
