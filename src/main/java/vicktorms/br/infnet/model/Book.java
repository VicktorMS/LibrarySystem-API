package vicktorms.br.infnet.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.FetchType.EAGER;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
    private String title;
	
	@Column(nullable = false)
    private String author;
	
	@Column(nullable = true)
    private int pages;

	@ElementCollection(targetClass = String.class, fetch = EAGER)
	private List<String> genres;

	public void updateFrom(Book updatedBook) {
		if (updatedBook.getTitle() != null) {
			this.setTitle(updatedBook.getTitle());
		}

		if (updatedBook.getAuthor() != null) {
			this.setAuthor(updatedBook.getAuthor());
		}

		if (updatedBook.getPages() != 0) {
			this.setPages(updatedBook.getPages());
		}
	}
	
}