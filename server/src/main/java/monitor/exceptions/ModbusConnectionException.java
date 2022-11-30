package monitor.exceptions;

public class ModbusConnectionException extends RuntimeException{
    public ModbusConnectionException(String message){
        super(message);
    }
}
