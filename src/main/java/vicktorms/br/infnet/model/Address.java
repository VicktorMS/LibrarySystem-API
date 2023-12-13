package vicktorms.br.infnet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Entity
public class Address {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private String cep;
    private String logradouro;
    private String complemento ;
    private String bairro;
    private String localidade;
    private String uf;
}