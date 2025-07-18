package com.fullcycle.admin.catologo.application.category.create;

import com.fullcycle.admin.catologo.application.UseCase;
import com.fullcycle.admin.catologo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends
        UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>>
{

}
