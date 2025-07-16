package com.fullcycle.admin.catologo.domain.pagination;

public record SearchQuery( int Page,
                           int perPgae,
                           String terms,
                           String sort,
                           String direction) {
}
