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
        
        List<BeneficiarioEntity> beneficiarios = template.query(SQL, (rs, row) -> {            
            BeneficiarioEntity beneficiario = new BeneficiarioEntity();
            
            beneficiario.setId(rs.getLong("id"));
            beneficiario.setApellido(rs.getString("apellido"));
            beneficiario.setNombre(rs.getString("nombre"));
            beneficiario.setDomicilio(rs.getString("domicilio"));
            beneficiario.setNroCuil(rs.getString("cuil"));
            beneficiario.setNroDocumento(rs.getString("nro_documento"));
            beneficiario.setSexo(rs.getString("sexo"));
            
            return beneficiario;
        });
        
        beneficiarios.forEach(beneficiario -> {
            System.out.println(beneficiario.toString());
        });
    }
}
