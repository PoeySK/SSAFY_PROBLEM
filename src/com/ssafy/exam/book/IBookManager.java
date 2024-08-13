package com.ssafy.exam.book;

public interface IBookManager {
    void add(Book book);
    void remove(String isbn);
    Book[] getList();
    Book searchByIsbn(String isbn);
    Book[] searchByTitle(String title);
    Magazine[] getMagazine();
    Book[] getBooks();
    int getTotalPrice();
    double getPriceAvg();
    void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
    void buy(String isbn, int quantity) throws ISBNNotFoundException;
}
