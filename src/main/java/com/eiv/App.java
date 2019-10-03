package com.eiv;


import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eiv.entities.BeneficiarioEntity;


@Configuration
public class App {
    
    public static final ApplicationContext CTX;
    private static final String SQL = "SELECT * FROM beneficiarios";
    @Autowired private Connection conn;
    
    static {
        CTX = new ClassPathXmlApplicationContext("app-config.xml");
    }
    
    public static void main(String[] args) {
        App app = CTX.getBean(App.class);
        app.run();
    }
    
    public void run() {
        JdbcTemplate template = new JdbcTemplate(conn);
        
        List<BeneficiarioEntity> beneficiarios = template.query(SQL, BeneficiarioEntity.class);
        
        beneficiarios.forEach(beneficiario -> {
            System.out.println(beneficiario.toString());
        });
    }
}
