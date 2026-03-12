package br.gov.sc.sctec.empreendedorismo.backend.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SctecEmpreendedorismoBackendApiApplication {

	public static void main(String[] args) {
        /*
        String databaseDirectory = "/data"; // Directory where files are stored
        String databaseName = "demo"; // The name of the database (e.g., for files named testdb.mv.db)
        boolean quietMode = true; // Set to false to see progress information

        try {
            // Ensure all connections are closed before executing
            // e.g., run 'SHUTDOWN' command via a connection, or close the EntityManagerFactory
            org.h2.tools.DeleteDbFiles.execute(databaseDirectory, databaseName, quietMode);
            System.out.println("Database files deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
		SpringApplication.run(SctecEmpreendedorismoBackendApiApplication.class, args);
	}

}
