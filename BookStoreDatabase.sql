Create database BookStore;
use BookStore;
CREATE TABLE Author (
    Author_ID INT,
    Author_First_Name VARCHAR(100),
    Author_Last_Name VARCHAR(100),
    CONSTRAINT pk_author PRIMARY KEY (Author_ID)
);

CREATE TABLE Publisher (
    Publisher_ID INT,
    Publisher_Name VARCHAR(350),
    Author_ID INT,
    CONSTRAINT pk_publisher PRIMARY KEY (Publisher_ID),
    CONSTRAINT Fk_author_ID FOREIGN KEY(Author_ID) REFERENCES Author (Author_ID)
);

CREATE TABLE Book (
    Book_ID INT,
    Title VARCHAR(300),
    ISBN VARCHAR(10),
    Publication_Date DATE,
    Author_ID INT,
    Publisher_ID INT,
    CONSTRAINT pk_book PRIMARY KEY (Book_ID),
    CONSTRAINT fk_book_Author_ID FOREIGN KEY (Author_ID) REFERENCES Author (Author_ID),
    CONSTRAINT fk_book_Publisher FOREIGN KEY (Publisher_ID) REFERENCES Publisher (Publisher_ID)
);

CREATE TABLE Customer (
    Customer_ID INT,
    Customer_First_Name VARCHAR(100),
    Customer_Last_Name VARCHAR(100),
    Customer_Email VARCHAR(200),
    Customer_Phone_Number VARCHAR(15),
    CONSTRAINT pk_customer PRIMARY KEY (Customer_ID)
);

CREATE TABLE Address (
    Address_ID INT,
    Street_Number VARCHAR(10),
    Street_Name VARCHAR(200),
    City VARCHAR(100),
    Postal_Code VARCHAR(5),
    CONSTRAINT pk_Address PRIMARY KEY (Address_ID)
);

CREATE TABLE Customer_Address (
    Customer_ID INT,
    Address_ID INT,
    CONSTRAINT pk_CustomerAddress PRIMARY KEY (Customer_ID, Address_ID),
    CONSTRAINT fk_CUSTOMER_ID_ FOREIGN KEY (Customer_ID) REFERENCES Customer (Customer_ID),
    CONSTRAINT fk_ADDRESS_ID_ FOREIGN KEY (Address_ID) REFERENCES Address (Address_ID)
);


CREATE TABLE Customer_Order (
    Order_ID INT AUTO_INCREMENT,
    Book_ID INT,
    Book_Price INT,
    Book_Quantity INT,
    order_date DATE,
    Customer_ID INT,
    CONSTRAINT pk_Customer_Order PRIMARY KEY (Order_ID),
    CONSTRAINT fk_CUSTOMER_ID FOREIGN KEY (Customer_ID) REFERENCES customer (Customer_ID),
    CONSTRAINT fk_BOOK_ID FOREIGN KEY (Book_ID) REFERENCES Book (Book_ID)
);


