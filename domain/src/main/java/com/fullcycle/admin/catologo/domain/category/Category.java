package com.fullcycle.admin.catologo.domain.category;

import com.fullcycle.admin.catologo.domain.AggregateRoot;
import com.fullcycle.admin.catologo.domain.validation.ValidationHandler;


import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {


    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    public Category(
          final  CategoryID anId,
          final  String aName,
          final  String aDescription,
          final  boolean isActive,
          final   Instant aCreationDate,
          final  Instant aUpdateDate,
          final  Instant aDeleteDate) {

        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdateDate;
        this.deletedAt = aDeleteDate;

    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive ){
    final var id = CategoryID.unique();
    final var now = Instant.now();
    final Instant deletedAt = isActive ? null : now;
    return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }



    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
