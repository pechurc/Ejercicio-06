package com.eiv;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eiv.entities.BeneficiarioEntity;
import com.eiv.entities.TitularCodigo;

@Configuration
public class App {

    public static final ApplicationContext CTX;
    private static final String SQL_BENEFICIARIO = "SELECT * FROM beneficiarios";
    private static final String SQL_TITULAR_CODIGO = "SELECT * FROM titulares_codigos";
    @Autowired
    private Connection conn;

    static {
        CTX = new ClassPathXmlApplicationContext("app-config.xml");
    }

    public static void main(String[] args) {
        App app = CTX.getBean(App.class);
        app.run();
    }

    public void run() {
        JdbcTemplate template = new JdbcTemplate(conn);

        List<BeneficiarioEntity> beneficiarios = template.query(SQL_BENEFICIARIO, 
                BeneficiarioEntity.class);

        beneficiarios.forEach(beneficiario -> {
            System.out.println(beneficiario.toString());
        });

        List<TitularCodigo> titulares = template.query(SQL_TITULAR_CODIGO, TitularCodigo.class);

        titulares.forEach(titular -> {
            System.out.println(titular.toString());
        });
    }
}
