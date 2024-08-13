package com.ssafy.exam.book;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
    private static IBookManager instance = new BookManagerImpl();
    private List<Book> books;

    private BookManagerImpl() {
        books = new ArrayList<>();
    }

    static IBookManager getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void remove(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                break;
            }
        }
    }

    @Override
    public Book[] getList() {
        Book[] temp = new Book[books.size()];
        for (int i = 0; i < books.size(); i++) {
            temp[i] = books.get(i);
        }
        return temp;
    }

    @Override
    public Book searchByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                return books.get(i);
            }
        }
        return null;
    }

    @Override
    public Book[] searchByTitle(String title) {
        Book[] temp = new Book[books.size()];
        int idx = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                temp[idx++] = books.get(i);
            }
        }
        return temp;
    }

    @Override
    public Magazine[] getMagazine() {
        Magazine[] temp = new Magazine[books.size()];
        int idx = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) instanceof Magazine) {
                temp[idx++] = (Magazine) books.get(i);
            }
        }
        return temp;
    }

    @Override
    public Book[] getBooks() {
        Book[] temp = new Book[books.size()];
        int idx = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) instanceof Magazine) {
            } else {
                temp[idx++] = books.get(i);
            }
        }
        return temp;
    }

    @Override
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < books.size(); i++) {
            total += books.get(i).getPrice();
        }
        return total;
    }

    @Override
    public double getPriceAvg() {
        return (double) getTotalPrice() / (double) books.size();
    }

    @Override
    public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
        boolean isCheck = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                isCheck = true;
                if (books.get(i).getQuantity() < quantity) {
                    throw new QuantityException();
                } else {
                    int pre = books.get(i).getQuantity();
                    books.get(i).setQuantity(pre - quantity);
                    System.out.println(books.get(i).toString());
                }
            }
        }
        if (!isCheck) {
            throw new ISBNNotFoundException(isbn);
        }
    }

    @Override
    public void buy(String isbn, int quantity) throws ISBNNotFoundException {
        boolean isCheck = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                isCheck = true;
                int pre = books.get(i).getQuantity();
                books.get(i).setQuantity(pre + quantity);
                System.out.println(books.get(i).toString());
            }
        }
        if (!isCheck) {
            throw new ISBNNotFoundException(isbn);
        }
    }
}
