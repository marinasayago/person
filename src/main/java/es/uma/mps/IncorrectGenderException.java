package es.uma.mps;

public class IncorrectGenderException extends RuntimeException{

    public IncorrectGenderException(String error){
        super(error);
    }
}
