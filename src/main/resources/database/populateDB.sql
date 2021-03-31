INSERT INTO Client (Name, Pasport_Serial, Pasport_Number, Telephone_Number, Adress)
VALUES ('Иванов Иван Иванович', 4500, 163166, '+79850001122', 'Москва, ул.Мира д.18 кв.18'),
       ('Иванов Петр Сергеевич', 4511, 188888, '+79450003344', 'Москва, ул.Мира д.11 кв.11'),
       ('Маркус Рашфорд', 4522, 155555, '+79270005588', 'Москва, ул.Мира д.22 кв.22');
INSERT INTO Bills (Client_Id, Sum_Bills, Data_Begin)
VALUES (1, 120000, '2021-03-19'),
       (1, 30000, '20220-02-21'),
       (1, 120000, '2019-03-21'),
       (2, 50000, '2021-03-21'),
       (3, 12000000, '2017-03-14');
INSERT INTO Bills (Client_Id, Sum_Bills, Data_Begin,Data_End)
VALUES (3, 1750000, '2021-03-19','2021-03-21');

INSERT INTO Transactions (Bill_Id, Sum_Transaction, Data_Transaction)
VALUES (1, 1750000, '2021-03-20'),
       (1, 30000, '2020-03-14'),
       (2, -15000, '2021-02-01'),
       (1, -10000, '2019-04-10'),
       (3, 1750000, '2021-03-19');