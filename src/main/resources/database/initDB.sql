CREATE TABLE  Client
(
    Id               serial PRIMARY KEY,
    Name             varchar(100) NOT NULL,
    Pasport_Serial   int          NOT NULL,
    Pasport_Number   int          NOT NULL,
    Telephone_Number varchar(100)  NOT NULL,

    Adress           varchar(100) NOT NULL

);

CREATE TABLE  Bills
(
    Client_Id  INTEGER REFERENCES Client (Id),
    Num_Bill   bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    Sum_Bills  double precision NOT NULL,
    Data_Begin date             NOT NULL,
    Data_End   date
);
CREATE TABLE  Transactions
(
    Bill_Id          bigint REFERENCES Bills (Num_Bill),
    Transaction_Id   bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    Sum_Transaction  double precision NOT NULL,
    Data_Transaction date             NOT NULL

);