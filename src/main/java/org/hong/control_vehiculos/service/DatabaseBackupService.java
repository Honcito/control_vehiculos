package org.hong.control_vehiculos.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DatabaseBackupService {
    private static final String DATABASE_PATH = "C:\\database\\control_vehiculos.db";
    private static final String BACKUP_DIRECTORY = "C:\\Control_Backup\\";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // Se ejecutará todos los días a la 01:00 AM
    @Scheduled(cron = "0 0 1 * * ?")
    public void backupDatabase() {
        try {
            File dbFile = new File(DATABASE_PATH);
            if (!dbFile.exists()) {
                System.err.println("No se encontró la base de datos" + DATABASE_PATH);
                return;
            }
            File backupDir = new File(BACKUP_DIRECTORY);
            if (!backupDir.exists()) {
                backupDir.mkdirs();
            }
            String backupFilename = "backup_" + LocalDate.now().format(DATE_FORMAT) + ".db";
            File backupFile = new File(BACKUP_DIRECTORY + backupFilename);

            Files.copy(dbFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copia de seguridad creada: " + backupFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error al hacer el backup " + e.getMessage());
        }
    }
}
