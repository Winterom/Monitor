CREATE TABLE segments
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(30) NOT NULL,
    protocol VARCHAR(20) NOT NULL,
    port     VARCHAR(80),
    baud_rate INTEGER,
    stop_bits VARCHAR(45),
    rs485_mode BOOLEAN,
    encoding VARCHAR(45),
    echo BOOLEAN,
    tcp_port INTEGER,
    timeout INTEGER default 3000
)