package vicktorms.br.infnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vicktorms.br.infnet.exception.ResourceNotFoundException;
import vicktorms.br.infnet.model.Book;
import vicktorms.br.infnet.repository.BookRepository;
import vicktorms.br.infnet.specification.BookSpecifications;

import java.util.List;

@Service 
public class BookService {
	
	@Autowired 
	private BookRepository bookRepository;
	
	public Book findBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Livro não encontrado"));
	}
	public List<Book> findAllBooks(String title, Integer pages) {
		Specification<Book> spec = Specification.where(null);
		if(title != null){
			spec = spec.and(BookSpecifications.withTitle(title));
		}
		if (pages != null){
			spec = spec.and(BookSpecifications.withPages(pages));
		}
		return bookRepository.findAll(spec);
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Long id, Book updatedBook){
		Book existingBook = findBookById(id);
		existingBook.updateFrom(updatedBook);
		return bookRepository.save(existingBook);
	}

	public void deleteBook(Long id){
		Book existingBook = findBookById(id);
		bookRepository.delete(existingBook);
	}
	
	

}
