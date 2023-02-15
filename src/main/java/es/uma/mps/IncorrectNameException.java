package es.uma.mps;

public class IncorrectNameException extends RuntimeException{
    public IncorrectNameException(String error){
        super(error);
    }
}
