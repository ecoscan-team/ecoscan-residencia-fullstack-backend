package br.com.ecoscan.ecoscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcoscanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoscanApplication.class, args);
	}

}


/*
{
  "nome": "Igor",
  "email": "igor@email.com"
}
*/

/*
{
  "descricao": "Descarte irregular de lixo",
  "localizacao": "Próximo ao rio",
  "usuario": {
    "id": 1
  }
}
*/