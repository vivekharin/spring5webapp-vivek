package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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
        Author auth = new Author("Vivek","Narayanan");
        Book book = new Book("Java Spring Boot","123123123");
        book.getAuthors().add(auth);
        auth.getBooks().add(book);
        Publisher pub = new Publisher("OReilly","LaneCove","Sydney", "NSW","2066");
        book.setPublisher(pub);
        pub.getBooks().add(book);
        authorRepository.save(auth);
        bookRepository.save(book);
        publisherRepository.save(pub);

        Author auth1 = new Author("Rod","Johnson");
        Book book1 = new Book("J2EE without EJB","666666");
        book1.getAuthors().add(auth1);
        auth1.getBooks().add(book1);
        pub.getBooks().add(book1);
        book1.setPublisher(pub);
        authorRepository.save(auth1);
        bookRepository.save(book1);
        publisherRepository.save(pub);




        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+bookRepository.count());

        System.out.println("Number of Authors: "+authorRepository.count());

        System.out.println("Number of Publisher: "+publisherRepository.count());

        System.out.println("Number of Books by publisher: "+pub.getBooks().size());


    }
}

