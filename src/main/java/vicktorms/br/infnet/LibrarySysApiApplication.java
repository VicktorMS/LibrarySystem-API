package vicktorms.br.infnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vicktorms.br.infnet.service.AddressService;
import vicktorms.br.infnet.service.BookService;

@SpringBootApplication
public class LibrarySysApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySysApiApplication.class, args);
	}

}
