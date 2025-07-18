package com.fullcycle.admin.catologo.application.category.update;

import com.fullcycle.admin.catologo.application.UseCase;
import com.fullcycle.admin.catologo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase
        extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}