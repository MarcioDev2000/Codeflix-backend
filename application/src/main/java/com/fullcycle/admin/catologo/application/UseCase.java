package com.fullcycle.admin.catologo.application;

import com.fullcycle.admin.catologo.domain.category.Category;

public abstract class UseCase<IN, OUT> {

   public abstract OUT execute(IN anIn);
}