package vicktorms.br.infnet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import vicktorms.br.infnet.model.Book;

@Repository 
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

}
