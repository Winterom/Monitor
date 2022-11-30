package monitor.polling.command;

import monitor.entity.PLC.ModBusCommand;


public interface Command {
    ReadCommand getCommand(ModBusCommand modBusCommand);
}
