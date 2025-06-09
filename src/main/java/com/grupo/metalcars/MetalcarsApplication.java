package com.grupo.metalcars;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MetalcarsApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;  // Usamos JdbcTemplate para ejecutar consultas SQL simples

    public static void main(String[] args) {
        SpringApplication.run(MetalcarsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            // Intentamos hacer una consulta simple para verificar la conexión
            String sql = "SELECT 1";
            jdbcTemplate.queryForObject(sql, Integer.class);
            System.out.println("¡Conexión exitosa a la base de datos!");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}


