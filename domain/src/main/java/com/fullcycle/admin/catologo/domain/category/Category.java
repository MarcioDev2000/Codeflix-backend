package com.fullcycle.admin.catologo.domain.category;
import com.fullcycle.admin.catologo.domain.AggregateRoot;
import com.fullcycle.admin.catologo.domain.utils.InstantUtils;
import com.fullcycle.admin.catologo.domain.validation.ValidationHandler;


import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> implements Cloneable {


    private String name;
    private String description;
    private boolean active;
    private final Instant createdAt;
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
        this.createdAt = Objects.requireNonNull(aCreationDate, "'createdAt' should not be null");
        this.updatedAt = Objects.requireNonNull(aUpdateDate, "'updatedAt' should not be null");
        this.deletedAt = aDeleteDate;

    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive ){
    final var id = CategoryID.unique();
    final var now = Instant.now();
    final Instant deletedAt = isActive ? null : now;
    return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }

    public static Category with(
            final CategoryID anId,
            final String name,
            final String description,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        return new Category(
                anId,
                name,
                description,
                active,
                createdAt,
                updatedAt,
                deletedAt
        );
    }

    public static Category with(final Category aCategory) {
        return with(
                aCategory.getId(),
                aCategory.name,
                aCategory.description,
                aCategory.isActive(),
                aCategory.createdAt,
                aCategory.updatedAt,
                aCategory.deletedAt
        );
    }


    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }


    public Category activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Category deactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = InstantUtils.now();
        }

        this.active = false;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Category update(final String aName, final String aDescription, final boolean isActive){
        this.name = aName;
        this.description = aDescription;

        this.active = isActive;
        this.deletedAt = isActive ? null : InstantUtils.now();

        this.updatedAt = Instant.now();
        return this;
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

    @Override
    public Category clone() {
        try {
            return (Category) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
