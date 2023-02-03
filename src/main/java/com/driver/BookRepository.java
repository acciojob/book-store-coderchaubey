package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private int id=1;
    Map<Integer,Book> bookMap=new HashMap<>();
    public BookRepository(){
        
    }

    public Book save(Book book){
        book.setId(id);
        bookMap.put(book.getId(), book);
        id++;
        return book;
    }

    public Book findBookById(int id){

        if (bookMap.containsKey(id)){
            return bookMap.get(id);
        }
        return null;
    }

    public List<Book> findAll(){
        List<Book> books=new ArrayList<>();
        for (Book book: bookMap.values()){
            books.add(book);
        }
        return books;
    }

    public void deleteAll(){
//        for (Integer i:bookMap.keySet()){
//            bookMap.remove(i);
//        }
        bookMap.clear();
        System.out.println("Deleted Successfully");

        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books=new ArrayList<>();
        for (Book book:bookMap.values()){
            if (book.getAuthor().equals(author)){
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books=new ArrayList<>();
        for (Book book:bookMap.values()){
            if (book.getGenre().equals(genre)){
                books.add(book);
            }
        }
        return books;
    }
    public String deleteBookById(int id){
        if(bookMap.containsKey(id)){
            bookMap.remove(id);
            return "Deleted Successfully";
        }
        return "Not Found";
    }

}
