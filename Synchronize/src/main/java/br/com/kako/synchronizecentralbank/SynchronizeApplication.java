package br.com.kako.synchronizecentralbank;

import br.com.kako.synchronizecentralbank.services.SicrediService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SynchronizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynchronizeApplication.class, args);
	}

}
