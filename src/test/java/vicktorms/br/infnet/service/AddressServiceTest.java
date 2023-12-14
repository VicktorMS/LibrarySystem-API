package vicktorms.br.infnet.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import vicktorms.br.infnet.model.Address;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class AddressServiceTest {

    private AddressService addressService;

    @BeforeEach
    void setUp() {
        addressService = new AddressService();
    }

    @Test
    void shouldGetAddressByCep() throws IOException, InterruptedException {
        String cep = "25225633";
        Address address = addressService.getAddressByCep(cep);

        assertEquals("25225-633", address.getCep());
        assertEquals("Rua Paraíba do Sul", address.getLogradouro());
        assertEquals("Campos Elíseos", address.getBairro());
        assertEquals("Duque de Caxias", address.getLocalidade());
        assertEquals("RJ", address.getUf());
    }


}
