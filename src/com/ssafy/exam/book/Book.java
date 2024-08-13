package com.ssafy.exam.book;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String desc;
    private int quantity;

    public Book() {

    }

    public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setPrice(price);
        setDesc(desc);
        setQuantity(quantity);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
