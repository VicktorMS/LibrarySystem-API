package vicktorms.br.infnet.controller;

import org.springframework.web.bind.annotation.*;

import vicktorms.br.infnet.model.Address;
import vicktorms.br.infnet.model.Book;
import vicktorms.br.infnet.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id){
		Book book = bookService.findBookById(id);
		return ResponseEntity.ok(book);
	}



	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) Integer pages
	){
		List<Book> bookList = bookService.findAllBooks(title, pages);
		return bookList.isEmpty()
				? ResponseEntity.noContent().build()
				: ResponseEntity.ok(bookList);
	}
	
	@PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book newBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
		Book updated = bookService.updateBook(id, updatedBook);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}

}
