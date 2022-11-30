/*На стандартном устройстве Modbus данные хранятся в 4 таблицах по 9999 значений в каждой:
Coils  — они доступны для чтения и записи и имеют внутреннюю адресацию от 0000 до 270E.
    Они занимают регистры 20001-29999 на устройстве Modbus.
Discrete Inputs—  доступны только для чтения и имеют внутреннюю адресацию от 0000 до 270E.
    Они занимают регистры 10001-19999 на устройстве Modbus.
Input Registers —  доступны только для чтения и имеют внутреннюю адресацию от 0000 до 270E.
    Они занимают регистры 30001-39999 на устройстве Modbus.
Holding Registers — доступны для чтения и записи и имеют внутреннюю адресацию от 0000 до 270E.
    Они занимают регистры 40001-49999 на устройстве Modbus.
Discrete Inputs (1) или Coils (2) — это 1 бит (1 байт).

Каждый Input Registers или  Holding Registers (3,4) представляет собой 1 слово или 16 бит (2 байта).

ref - это контакт (в вашем случае), который вы хотите прочитать.
Например, если вы хотите прочитать первый контакт под номером 10001,
вы должны передать 0 (так как они имеют внутренний адрес 0000-270E).
Второй параметр count — это количество контактов (битов), которые вы хотите прочитать.
Если вы хотите прочитать только контакт 10001, вы можете передать 1 (только один контакт).*/

public class ModbusAddressConverter {
    public static int convertDiscreteInputs(int address){
        if(address<10001||address>19999){
            throw new RuntimeException("Невалидный Coils адресс");
        }
        return address-10001;
    }
    public static int convertCoils(int address){
        if(address<20001||address>29999){
            throw new RuntimeException("Невалидный Discrete Inputs адресс");
        }
        return address-20001;
    }
    public static int convertInputRegisters(int address){
        if(address<30001||address>39999){
            throw new RuntimeException("Невалидный Input Registers адресс");
        }
        return address-30001;
    }
    public static int convertHoldingRegisters(int address){
        if(address<40001){
            throw new RuntimeException("Невалидный Holding Registers адресс");
        }
        System.out.println(address-40001);
        return address-40001;
    }
}
