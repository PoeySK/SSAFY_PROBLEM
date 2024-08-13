package com.ssafy.exam.book;

public class Magazine extends Book {
    private int year;
    private int month;

    public Magazine() {

    }

    public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month, int quantity) {
        super(isbn, title, author, publisher, price, desc, quantity);
        setYear(year);
        setMonth(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "year=" + year +
                ", month=" + month +
                ", isbn='" + getIsbn() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", price=" + getPrice() +
                ", desc='" + getDesc() + '\'' +
                ", quantity=" + getQuantity() +
                '}';
    }
}
