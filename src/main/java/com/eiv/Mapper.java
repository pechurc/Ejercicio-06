package com.eiv;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.eiv.annotations.Mappeable;
import com.eiv.annotations.MappedTo;

public class Mapper<T> {
    
    public T mapRow(ResultSet resultSet, Class<T> clazz) {
        
        if (clazz.getAnnotation(Mappeable.class) == null) {
            throw new RuntimeException();
        }

        try {
            T t = clazz.newInstance();
                        
            List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
            
            fields.forEach(field -> {
                if (field.isAnnotationPresent(MappedTo.class)) {
                    field.setAccessible(true);
                    MappedTo mappedTo = field.getAnnotation(MappedTo.class);
                    
                    try {  
                        if (field.getType() == Long.class) {                        
                            field.set(t, resultSet.getLong(mappedTo.columnName()));
                        }
                        
                        if (field.getType() == Integer.class) {                        
                            field.set(t, resultSet.getInt(mappedTo.columnName()));
                        }
                        
                        if (field.getType() == BigDecimal.class) {                        
                            field.set(t, resultSet.getBigDecimal(mappedTo.columnName()));
                        }
                        
                        if (field.getType() == String.class) {                        
                            field.set(t, resultSet.getString(mappedTo.columnName()));
                        }                    
                    } catch (IllegalArgumentException 
                            | IllegalAccessException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            
            return t;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
