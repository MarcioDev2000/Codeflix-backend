package com.fullcycle.admin.catologo.domain;

import com.fullcycle.admin.catologo.domain.category.Category;
import com.fullcycle.admin.catologo.domain.category.CategoryValidator;
import com.fullcycle.admin.catologo.domain.validation.ValidationHandler;

public class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id){
        super((id));
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator((Category) this, handler).validate();
    }

}
