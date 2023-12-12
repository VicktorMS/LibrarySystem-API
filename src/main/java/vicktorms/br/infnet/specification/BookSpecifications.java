package vicktorms.br.infnet.specification;

import org.springframework.data.jpa.domain.Specification;
import vicktorms.br.infnet.model.Book;

public class BookSpecifications {

    public static Specification<Book> withTitle(String title){
        return ((root, query, builder) ->
                builder.equal(root.get("title"), title));
    }

    public static Specification<Book> withPages(Integer pages){
        return ((root, query, builder) ->
                builder.equal(root.get("pages"), pages));
    }
}
