package com.api.crud.services;

import com.api.crud.models.BookModel;
import com.api.crud.repositories.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    IBookRepository bookRepository;

    public ArrayList<BookModel> getBooks(){
        return (ArrayList<BookModel>) bookRepository.findAll();
    }

    public BookModel saveBook(BookModel book){
        return bookRepository.save(book);
    }

    public Optional<BookModel> getById(Long id){
        return bookRepository.findById(id);
    }

    public BookModel updateById(BookModel request, Long id){
        BookModel book = bookRepository.findById(id).get();
        book.setTitulo(request.getTitulo());
        book.setAutor(request.getAutor());
        book.setGenero(request.getGenero());
        book.setAnioPublicacion(request.getAnioPublicacion());
        bookRepository.save(book);
        return book;
    }

    public Boolean deleteBook(Long id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}