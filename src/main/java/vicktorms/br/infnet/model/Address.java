package vicktorms.br.infnet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
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
