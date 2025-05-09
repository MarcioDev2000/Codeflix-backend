package com.fullcycle.admin.catologo.domain;

import com.fullcycle.admin.catologo.domain.category.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory(){
       final var expectedName = "filme";
       final var expectedDescription = "A Categoria mais assistida";
       final var expectedIsActive = true;

       final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

       Assertions.assertNotNull(actualCategory);
       Assertions.assertNotNull(actualCategory.getId());
       Assertions.assertEquals(expectedName, actualCategory.getName());
       Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
       Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
       Assertions.assertNotNull(actualCategory.getCreatedAt());
       Assertions.assertNotNull(actualCategory.getUpdatedAt());
       Assertions.assertNull(actualCategory.getDeletedAt());

    }
}
