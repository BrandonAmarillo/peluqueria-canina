package com.mycompany.util;

import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    
    private static final EntityManagerFactory emf;

    static {
        Dotenv dotenv = Dotenv.configure().directory(new java.io.File(".").getAbsolutePath()).load();

        // Construimos la base de la URL
        String dbUrl = "jdbc:mysql://" + dotenv.get("DB_HOST") + ":" + dotenv.get("DB_PORT") + "/" + dotenv.get("DB_NAME");

        // Concatenamos los parámetros adicionales de MySQL
        dbUrl += "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", dbUrl);
        System.out.println(dbUrl);
        properties.put("jakarta.persistence.jdbc.user", dotenv.get("DB_USER"));
        properties.put("jakarta.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));

        emf = Persistence.createEntityManagerFactory("jpaPeluCaninaPU", properties);

        
    }
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
