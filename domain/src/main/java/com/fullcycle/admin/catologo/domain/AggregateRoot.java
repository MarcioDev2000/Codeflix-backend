package com.fullcycle.admin.catologo.domain;

public class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id){
        super((id));
    }
}
