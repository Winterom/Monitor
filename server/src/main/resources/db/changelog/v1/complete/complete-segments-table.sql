INSERT INTO segments(name,protocol,port,baud_rate,stop_bits,rs485_mode,encoding,echo)
        VALUES ('Основной','MODBUS_RTU','COM3',115200,'TWO_STOP_BITS',true,'rtu',false),
               ('Основной2','MODBUS_RTU','COM3',115200,'TWO_STOP_BITS',true,'rtu',false);