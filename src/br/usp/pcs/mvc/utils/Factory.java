package br.usp.pcs.mvc.utils;

import br.usp.pcs.mvc.Package.Interfaces.IPackage;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andreebr on 29/11/16.
 */
public class Factory<T> {
    private Class<T> _entity;

    public Factory(Class<T> entity) {
        _entity = entity;
    }

    public T mapResult(ResultSet resultSet) throws IllegalAccessException, InstantiationException, SQLException {
        T entity = _entity.newInstance();

        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().equals(int.class)) {
                field.set(entity, resultSet.getInt(field.getName().toUpperCase()));
            } else if (field.getType().equals(String.class)) {
                field.set(entity, resultSet.getString(field.getName().toUpperCase()));
            } else if (field.getType().equals(Double.class)) {
                field.set(entity, resultSet.getDouble(field.getName().toUpperCase()));
            }
        }

        return entity;
    }
}
