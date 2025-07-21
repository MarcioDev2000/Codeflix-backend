package com.fullcycle.admin.catologo.infratructure.category;


import com.fullcycle.admin.catologo.domain.category.Category;
import com.fullcycle.admin.catologo.domain.category.CategoryGateway;
import com.fullcycle.admin.catologo.domain.category.CategoryID;
import com.fullcycle.admin.catologo.domain.pagination.Pagination;
import com.fullcycle.admin.catologo.domain.pagination.SearchQuery;
import com.fullcycle.admin.catologo.infratructure.category.persistence.CategoryJpaEntity;
import com.fullcycle.admin.catologo.infratructure.category.persistence.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryMySQLGateway implements CategoryGateway {

    private final CategoryRepository repository;

    public CategoryMySQLGateway(final CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(final Category aCategory) {
        return this.repository.save(CategoryJpaEntity.from(aCategory)).toAggregate();
    }

    @Override
    public void deleteById(CategoryID anId) {

    }

    @Override
    public Optional<Category> findById(CategoryID anId) {
        return Optional.empty();
    }

    @Override
    public Category update(Category aCategory) {
        return null;
    }

    @Override
    public Pagination<Category> findAll(SearchQuery aQuery) {
        return null;
    }


}
