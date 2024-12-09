package org.hong.control_vehiculos;

import lombok.extern.slf4j.Slf4j;
import org.hong.control_vehiculos.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ControlVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlVehiculosApplication.class, args);
	}

	@Autowired
	private PropietarioRepository propietarioRepository;

	@Bean
	CommandLineRunner init() {
		return args -> {
			propietarioRepository.findAll().forEach(propietario -> {
				log.info(propietario.getNombre());
			});
		};

	}


}
