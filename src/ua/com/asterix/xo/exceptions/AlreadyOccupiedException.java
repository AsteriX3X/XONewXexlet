package ua.com.asterix.xo.exceptions;

public class AlreadyOccupiedException extends AbstractXOException {

    public AlreadyOccupiedException() {
        System.out.println("Уже занято, выберите другое поле");
    }

}
