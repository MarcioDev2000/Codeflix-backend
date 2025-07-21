package com.fullcycle.admin.catologo.application.category.retrieve.list;

import com.fullcycle.admin.catologo.domain.category.CategoryGateway;
import com.fullcycle.admin.catologo.domain.pagination.Pagination;
import com.fullcycle.admin.catologo.domain.pagination.SearchQuery;

import java.util.Objects;

public class DefaultListCategoriesUseCase extends ListCategoriesUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultListCategoriesUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    public Pagination<CategoryListOutput> execute(final SearchQuery aQuery) {
        return this.categoryGateway.findAll(aQuery)
                .map(CategoryListOutput::from);
    }
}