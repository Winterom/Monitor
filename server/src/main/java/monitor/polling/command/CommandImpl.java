package monitor.polling.command;

import monitor.entity.PLC.EModBusCommandType;
import monitor.entity.PLC.ModBusCommand;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CommandImpl implements Command{
    private final Map<EModBusCommandType,ReadCommand> commandMap = new ConcurrentHashMap<>();

    public CommandImpl() {
        commandMap.put(EModBusCommandType.READ_COILS,new ReadCoilsCommand());
        commandMap.put(EModBusCommandType.READ_DISCRETE_INPUT,new ReadDiscreteInputsCommand());
        commandMap.put(EModBusCommandType.READ_INPUT_REGISTER,new ReadInputsRegister());
        commandMap.put(EModBusCommandType.READ_HOLDING_REGISTER,new ReadHoldingRegister());
    }

    @Override
    public ReadCommand getCommand(ModBusCommand modBusCommand) {
       ReadCommand command =  commandMap.get(modBusCommand.getCommandType());
       command.setModbusCommand(modBusCommand);
       return command;
    }
}
