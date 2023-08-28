package org.example.project3.controllers;

import jakarta.validation.Valid;
import org.example.project3.services.BooksService;
import org.example.project3.services.PeopleService;

import org.example.project3.models.Book;
import org.example.project3.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;
    private final PeopleService peopleService;

    @Autowired
    public BooksController(BooksService booksService,PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
}

    @GetMapping()
    public String index(Model model,
                        @RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "count",required = false) Integer count,
                        @RequestParam(value = "sortByYear", required = false) boolean sort){
        if(page == null && count == null){
            model.addAttribute("books",booksService.findAll(sort));
        } else{
            model.addAttribute("books", booksService.findAll(page,count,sort));
        }

    return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        //Получим одну книгу по id
        model.addAttribute("book",booksService.findOne(id));
        Person owner = booksService.getBookOwner(id);

        if(owner!=null){
            model.addAttribute("owner",owner);
        } else{
            model.addAttribute("people",peopleService.findAll());
        }
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "books/new";
        }
        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book", booksService.findOne(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "books/edit";
        }
        booksService.update(id,book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        booksService.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int id){
        booksService.release(id);
        return "redirect:/books/"+id;
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("person") Person person){
        booksService.assign(id,person);
        return "redirect:/books/" + id;
    }

    @GetMapping("/search")
    public String searchPage()
    {
        return "books/search";
    }
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(value="bookName",required = false) String name){
        model.addAttribute("booksList",booksService.findByNameStartingWith(name));
        return "books/search";
    }
}

