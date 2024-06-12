package com.api.crud.controllers;

import com.api.crud.models.BookModel;
import com.api.crud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ArrayList<BookModel> getBooks(){
        return this.bookService.getBooks();
    }

    @PostMapping
    public BookModel saveBook(@RequestBody BookModel book){
        return this.bookService.saveBook(book);
    }

    @GetMapping(path="/{id}")
    public Optional<BookModel> getBookById(@PathVariable("id") Long id) {
        return this.bookService.getById(id);
    }

    @PutMapping(path="/{id}")
    public BookModel updateBookById(@RequestBody BookModel request, @PathVariable("id") Long id) {
        return this.bookService.updateById(request, id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok= this.bookService.deleteBook(id);

        if(ok){
            return "User with id " + id + " has been deleted";
        } else{
            return "Error, problem with the id " + id + "delete";
        }
    }
}