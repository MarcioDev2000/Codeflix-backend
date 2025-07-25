package com.fullcycle.admin.catologo.domain.category;

import com.fullcycle.admin.catologo.domain.pagination.Pagination;
import com.fullcycle.admin.catologo.domain.pagination.SearchQuery;

import java.util.Optional;

    public interface CategoryGateway {
        Category create (Category aCategory);

        void deleteById(CategoryID anId);

        Optional<Category> findById(CategoryID anId);

        Category update(Category aCategory);

        Pagination<Category> findAll (SearchQuery aQuery);
    }

