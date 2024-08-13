package com.ssafy.exam.book;

public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10);
        Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20);
        Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "1월 알고리즘", 30);
        Magazine m1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1, 40);

        IBookManager bm = BookManagerImpl.getInstance();
        bm.add(b1);
        bm.add(b2);
        bm.add(b3);
        bm.add(m1);

        System.out.println("***************도서 전체 목록***************");
        for (int i = 0; i < bm.getList().length; i++) {
            System.out.println(bm.getList()[i].toString());
        }
        System.out.println("***************일반 도서 목록***************");
        for(int i=0; i<bm.getBooks().length; i++) {
            if(bm.getBooks()[i] == null) {
                break;
            }
            System.out.println(bm.getBooks()[i].toString());
        }
        System.out.println("***************잡지 목록***************");
        for(int i=0; i<bm.getMagazine().length; i++) {
            if(bm.getMagazine()[i] == null) {
                break;
            }
            System.out.println(bm.getMagazine()[i].toString());
        }
        System.out.println("***************도서 제목 포함검색***************");
        String findTitle = "Java";
        Book[] search = bm.searchByTitle(findTitle);
        for(int i=0; i<search.length; i++) {
            if(search[i] == null) {
                break;
            }
            System.out.println(search[i].toString());
        }
        System.out.println("***************도서 가격***************");
        System.out.println("도서 가격 총합 : " + bm.getTotalPrice());
        System.out.println("도서 가격 평균 : " + bm.getPriceAvg());

        String buyIsbn = "21424";
        int bc = 11;
        System.out.println("***************도서 판매:" + buyIsbn + ", " + bc + "***************");
        try {
            bm.sell(buyIsbn, bc);
        } catch (ISBNNotFoundException | QuantityException e) {
            System.out.println(e.getMessage());
        }

        String sellIsbn = "21424";
        int sc = 10;
        System.out.println("***************도서 구매:" + sellIsbn + ", " + sc + "***************");
        try {
            bm.buy(sellIsbn, sc);
        } catch (ISBNNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("***************도서 판매:" + buyIsbn + ", " + bc + "***************");
        try {
            bm.sell(buyIsbn, bc);
        } catch (ISBNNotFoundException | QuantityException e) {
            System.out.println(e.getMessage());
        }
    }
}
