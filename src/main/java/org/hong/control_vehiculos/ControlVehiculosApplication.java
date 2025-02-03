package org.hong.control_vehiculos;

import lombok.extern.slf4j.Slf4j;
import org.hong.control_vehiculos.repository.PropietarioRepository;
import org.hong.control_vehiculos.service.DatabaseBackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication

public class ControlVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlVehiculosApplication.class, args);
	}

	@Autowired
	private PropietarioRepository propietarioRepository;

	@Autowired
	private DatabaseBackupService databaseBackupService;

	@Bean
	CommandLineRunner init() {
		return args -> {

			// Prueba de copia de seguridad des comentar para testear
			// databaseBackupService.backupDatabase();

			// Probando listar propietarios por nombre
			propietarioRepository.findAll().forEach(propietario -> {
				log.info(propietario.getNombre());
			});
		};
	}
}
