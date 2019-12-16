CREATE TABLE ROOM_TYPE ( -- Typ pokoju, do typów mozna potem dodac jakies kolory/zdjecia
    type_id INT NOT NULL,
    name VARCHAR(16) NOT NULL, -- Np. kuchnia, kibel, pokoj hr, pokoj dev
    PRIMARY KEY (type_id)
);

CREATE TABLE ROOM ( -- Pokój w biurze 
    room_id INT NOT NULL,
    type_id INT NOT NULL,
    name VARCHAR(16) NOT NULL, -- Tutaj np. pokoj teamu "Dobre chlopaki"
    capacity INT NOT NULL, -- Ilosc osob ktore moga pracowac/siedziec w pokoju
    PRIMARY KEY (room_id),
    FOREIGN KEY (type_id) REFERENCES ROOM_TYPE (type_id)
);

CREATE TABLE ITEM_TYPE ( -- Typ przedmiotu - Tylko taki wchodzacy w stanowisko pracy
    type_id INT NOT NULL,
    name VARCHAR(16) NOT NULL, -- np. biurko, krzeslo, laptop, twoj stary
    PRIMARY KEY (type_id)
);

CREATE TABLE ITEM ( -- Przedmiot - Tylko taki wchodzacy w stanowisko pracy
    item_id INT NOT NULL,
    type_id INT NOT NULL,
    name VARCHAR(16) NOT NULL, -- Tutaj jak wyzej, mozna dodac ze np. Czarne biurko z podnosnikiem
    width FLOAT NOT NULL, -- Mozna potem tez wysylac jak bedziemy chcieli modyfikowac
    length FLOAT NOT NULL, -- Narazie nie bedzie potrzebne, ale niech zostanie jak potem
    height FLOAT NOT NULL, -- bedziemy dodawac funkcjonalnosci
    PRIMARY KEY (item_id),
    FOREIGN KEY (type_id) REFERENCES ITEM_TYPE (type_id)
);

CREATE TABLE DECORATION_TYPE ( -- Typ dekoracji
    type_id INT NOT NULL,
    name VARCHAR(16) NOT NULL, -- np. kwiatek, dupa
    PRIMARY KEY (type_id)
);

CREATE TABLE DECORATION ( -- Przedmiot - Tylko taki wchodzacy w stanowisko pracy
    decoration_id INT NOT NULL,
    type_id INT NOT NULL,
    name VARCHAR(16) NOT NULL, -- Tutaj jak wyzej, mozna dodac ze np. Czarne biurko z podnosnikiem
    width FLOAT NOT NULL, -- Mozna potem tez wysylac jak bedziemy chcieli modyfikowac
    length FLOAT NOT NULL, -- Narazie nie bedzie potrzebne, ale niech zostanie jak potem
    height FLOAT NOT NULL, -- bedziemy dodawac funkcjonalnosci
    PRIMARY KEY (decoration_id),
    FOREIGN KEY (type_id) REFERENCES DECORATION_TYPE (type_id)
);

CREATE TABLE OFFICE (
    office_id INT NOT NULL,
    name VARCHAR(16) NOT NULL, -- Tutaj chyba useless, ale moze byc np. Tryton Office
    country VARCHAR(16) NOT NULL,
    city VARCHAR(64) NOT NULL,
    region VARCHAR(16) NOT NULL,
    postal_code VARCHAR(12) NOT NULL,
    address VARCHAR(32) NOT NULL,
    PRIMARY KEY (office_id)
);

CREATE TABLE OFFICE_USER ( -- Nasz "pracownik"
    user_id VARCHAR(36) NOT NULL,
    username VARCHAR(16) NOT NULL,
    password VARCHAR(255) NOT NULL, -- Do ustalenia jeszcze jak to trzymamy
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP,
    deleted BOOLEAN NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE USER_DETAILS (
    user_id VARCHAR(36) NOT NULL,
    email VARCHAR(16) NOT NULL,
    name VARCHAR(16) NOT NULL,
    second_name VARCHAR(16),
    surname VARCHAR(16) NOT NULL,
    birth_date TIMESTAMP NOT NULL,
    parent_names VARCHAR(32) NOT NULL,
    nationality VARCHAR(16) NOT NULL,
    country VARCHAR(16) NOT NULL, -- Tutaj mozna wywalic do nastepnej tabeli, ale imo moze zostac
    city VARCHAR(64) NOT NULL,
    region VARCHAR(16) NOT NULL,
    postal_code VARCHAR(12) NOT NULL,
    address VARCHAR(32) NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES OFFICE_USER (user_id)
);

CREATE TABLE WORKSTATIONS ( -- Tutaj dane stanowisko
    workstation_id INT NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    UNIQUE (user_id), -- nie wiem czy to dziala, ale podobno jo - chodzi o to zeby dana osoba miala 1 stanowisko pracy
    PRIMARY KEY (workstation_id),
    FOREIGN KEY (user_id) REFERENCES OFFICE_USER (user_id)
);

CREATE TABLE WORKSTATIONS_COMPOSITION ( -- Z czego sie sklada stanowisko pracy
    workstation_id INT NOT NULL,
    item_id INT NOT NULL,
    PRIMARY KEY (workstation_id, item_id),
    FOREIGN KEY (workstation_id) REFERENCES WORKSTATIONS (workstation_id),
    FOREIGN KEY (item_id) REFERENCES ITEM (item_id)
);

CREATE TABLE ROOM_LAYOUT (
    room_id INT NOT NULL,
    workstation_id INT NOT NULL,
    x1_location INT NOT NULL, -- Wystarcza 2 punkty (x1,y1) i (x2,y2) - start i koniec figury
    y1_location INT NOT NULL,
    x2_location INT NOT NULL, 
    y2_location INT NOT NULL,
    rotation VARCHAR(5) NOT NULL, -- North/South/West/East
    PRIMARY KEY (room_id, workstation_id),
    FOREIGN KEY (room_id) REFERENCES ROOM (room_id),
    FOREIGN KEY (workstation_id) REFERENCES WORKSTATIONS (workstation_id)
);

CREATE TABLE DECORATION_LAYOUT ( -- Gdzie w biurze stoi jaka dekoracja
    decoration_id INT NOT NULL,
    office_id INT NOT NULL,
    x1_location INT NOT NULL, -- Wystarcza 2 punkty (x1,y1) i (x2,y2) - start i koniec figury
    y1_location INT NOT NULL,
    x2_location INT NOT NULL, 
    y2_location INT NOT NULL,
    rotation VARCHAR(5) NOT NULL, -- North/South/West/East
    PRIMARY KEY (decoration_id),
    FOREIGN KEY (decoration_id) REFERENCES DECORATION (decoration_id),
    FOREIGN KEY (office_id) REFERENCES OFFICE (office_id)
);

CREATE TABLE OFFICE_LAYOUT ( -- Układ pokojów
    office_id INT NOT NULL,
    room_id INT NOT NULL,
    x1_location INT NOT NULL, -- Wystarcza 2 punkty (x1,y1) i (x2,y2) - start i koniec figury
    y1_location INT NOT NULL,
    x2_location INT NOT NULL, 
    y2_location INT NOT NULL,
    PRIMARY KEY (office_id, room_id),
    FOREIGN KEY (office_id) REFERENCES OFFICE (office_id),
    FOREIGN KEY (room_id) REFERENCES ROOM (room_id)
);
