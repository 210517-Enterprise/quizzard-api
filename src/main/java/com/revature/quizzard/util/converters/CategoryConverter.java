package com.revature.quizzard.util.converters;

import com.revature.quizzard.entities.Category;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Component
@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            throw new IllegalArgumentException();
        }
        return category.toString();
    }

    @Override
    public Category convertToEntityAttribute(String categoryName) {
        System.out.println(categoryName);
        return Stream.of(Category.values())
                .filter(c -> c.toString().equals(categoryName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
