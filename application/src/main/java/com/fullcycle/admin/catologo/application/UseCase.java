package com.fullcycle.admin.catologo.application;

import com.fullcycle.admin.catologo.domain.category.Category;

public class UseCase {

  public Category execute(){
      return Category.newCategory("Categoria Teste", "Descrição Teste", true);
  }
}