package com.fullcycle.admin.catologo.application.category.delete;

import com.fullcycle.admin.catologo.domain.category.CategoryGateway;
import com.fullcycle.admin.catologo.domain.category.CategoryID;

import java.util.Objects;

public class DefaultDeleteCategoryUseCase extends  DeleteCategoryUseCase{


    private final CategoryGateway categoryGateway;


    public DefaultDeleteCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public void execute(final String anIn) {
        this.categoryGateway.deleteById(CategoryID.from(anIn));
    }
}
