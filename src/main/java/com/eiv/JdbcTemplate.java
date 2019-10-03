package com.eiv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private Connection conn;
    
    public JdbcTemplate(Connection conn) {
        this.setConnection(conn);
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    
    public <T> List<T> query(String sql, Class<T> clazz) {
        Mapper<T> mapper = new Mapper<>();
        List<T> resultados = new ArrayList<>();
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                T t = mapper.mapRow(rs, clazz);                
                resultados.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e.getMessage(), e);            
        }
        
        return resultados;
    }
}
