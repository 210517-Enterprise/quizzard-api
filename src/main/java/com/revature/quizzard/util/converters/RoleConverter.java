package com.revature.quizzard.util.converters;

import com.revature.quizzard.entities.Role;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Component
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        if (role == null) {
            throw new IllegalArgumentException();
        }
        return role.toString();
    }

    @Override
    public Role convertToEntityAttribute(String roleName) {
        return Stream.of(Role.values())
                .filter(r -> r.toString().equals(roleName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
