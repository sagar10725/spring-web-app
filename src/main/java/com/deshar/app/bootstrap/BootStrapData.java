package com.deshar.app.bootstrap;

import com.deshar.app.domain.Author;
import com.deshar.app.domain.Book;
import com.deshar.app.domain.Publisher;
import com.deshar.app.repository.AuthorRepository;
import com.deshar.app.repository.BookRepository;
import com.deshar.app.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher p1 = new Publisher();
        p1.setName("Deshar Publisher");
        p1.setAddressLine("123 main st");
        p1.setCity("Riverview");
        p1.setState("Florida");
        p1.setZipCode("33578");

        publisherRepository.save(p1);

        Author a1 = new Author("Sagar", "Evans");
        Book b1 = new Book("Springboot 5 demo", "1340");

        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);
        b1.setPublisher(p1);
        p1.getBooks().add(b1);

        authorRepository.save(a1);
        bookRepository.save(b1);
        publisherRepository.save(p1);


        Author a2 = new Author("Noah", "Evans");
        Book b2 = new Book("Spring and hibernate", "10728");

        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        b2.setPublisher(p1);
        p1.getBooks().add(b2);

        authorRepository.save(a2);
        bookRepository.save(b2);
        publisherRepository.save(p1);

        System.out.println("Publisher number of books : "+ p1.getBooks().size());
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
