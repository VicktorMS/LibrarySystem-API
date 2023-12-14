package vicktorms.br.infnet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vicktorms.br.infnet.model.Book;
import vicktorms.br.infnet.repository.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void shouldCreateBook(){
        List<String> genres = Arrays.asList("Medieval", "Ação", "Aventura", "Magia");
        Book book = createBook("Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien",504, genres);

        Book createdBook = bookService.createBook(book);

        assertNotNull(createdBook.getId(),"O ID do livro criado não deve ser nulo");
        assertEquals(book.getTitle(), createdBook.getTitle(), "O título do livro criado deve ser igual ao título fornecido");
        assertEquals(book.getAuthor(), createdBook.getAuthor(), "O autor do livro criado deve ser igual ao autor fornecido");
        assertEquals(book.getPages(), createdBook.getPages(), "O número de páginas do livro criado deve ser igual ao número fornecido");
        assertEquals(book.getGenres(), createdBook.getGenres(), "Os gêneros do livro criado devem ser iguais aos gêneros fornecidos");
    }

    @Test
    public void shouldUpdateBook() {
        List<String> initialGenres = Arrays.asList("Medieval", "Ação", "Aventura", "Magia");
        Book initialBook = createBook("Senhor dos Aneis", "J.R.R. Tolkien", 500, initialGenres);
        Book savedBook = bookRepository.save(initialBook);

        savedBook.setTitle("Senhor dos Anéis: O retorno do rei");

        Book updatedBook = bookService.updateBook(savedBook.getId(), savedBook);

        Book retrievedBook = bookRepository.findById(savedBook.getId()).orElseThrow();

        assertNotNull(retrievedBook.getId(), "O ID do livro não deve ser nulo");
        assertEquals(savedBook.getId(), retrievedBook.getId(), "O ID do livro não deve ser alterado");
        assertEquals(savedBook.getTitle(), retrievedBook.getTitle(), "O título do livro deve ser atualizado");
        assertEquals(savedBook.getAuthor(), retrievedBook.getAuthor(), "O autor do livro deve ser atualizado");
        assertEquals(savedBook.getPages(), retrievedBook.getPages(), "O número de páginas do livro deve ser atualizado");
        assertEquals(new ArrayList<>(savedBook.getGenres()), new ArrayList<>(updatedBook.getGenres()), "Os gêneros do livro devem ser atualizados");

    }

    @Test
    public void shouldThrowExceptionWhenCreatingBookWithNullValue() {
        List<String> genres = Arrays.asList("Medieval", "Ação", "Aventura", "Magia");
        Book book = createBook(null, "J.R.R. Tolkien", 504, genres);

        assertThrows(NullPointerException.class, () -> {
            bookService.createBook(book);
        }, "Deveria lançar uma exceção ao criar um livro com título nulo");
    }



    private Book createBook(String title, String author, int pages, List<String> genres) {
        return new Book(null, title, author, pages, genres);
    }
}
