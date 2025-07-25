package com.fullcycle.admin.catologo.application.category.create;

import com.fullcycle.admin.catologo.domain.category.Category;
import com.fullcycle.admin.catologo.domain.category.CategoryGateway;
import com.fullcycle.admin.catologo.domain.validation.handler.Notification;
import io.vavr.API;
import io.vavr.control.Either;

import static io.vavr.API.Left;
import static io.vavr.API.Try;
import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand aCommand) {
        final var aName = aCommand.name();
        final var aDescription = aCommand.description();
        final var isActive = aCommand.isActive();

        final var notification = Notification.create();

        final var aCategory = Category.newCategory(aName, aDescription, isActive);
        aCategory.validate(notification);

        return notification.hasError() ? API.Left(notification) : create(aCategory);
    }

    private Either<Notification, CreateCategoryOutput> create(final Category aCategory){

          return Try( () -> this.categoryGateway.create(aCategory))
                  .toEither()
                  .bimap(Notification::create, CreateCategoryOutput::from);
    }


}
