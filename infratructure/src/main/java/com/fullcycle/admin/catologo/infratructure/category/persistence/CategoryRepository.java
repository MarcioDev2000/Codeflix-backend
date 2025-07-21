package com.fullcycle.admin.catologo.infratructure.category.persistence;

import org.hibernate.query.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryJpaEntity, String> {

}
