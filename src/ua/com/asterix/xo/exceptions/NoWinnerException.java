package ua.com.asterix.xo.exceptions;

public class NoWinnerException extends AbstractXOException {
    public NoWinnerException() {
        System.out.println("Ничья! (Победила дружба!");
    }
}
