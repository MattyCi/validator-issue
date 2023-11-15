package com.example;

import io.micronaut.context.BeanContext;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.validation.validator.constraints.ConstraintValidator;
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@Introspected
class UserRegistrationValidator implements ConstraintValidator<ValidUserRegistration, UserRegistrationRequest> {

    // @Inject
    /*SomeService someService;

    @Inject
    UserRegistrationValidator(SomeService someService) {
        this.someService = someService;
    }
*/
    @Override
    public boolean isValid(UserRegistrationRequest value, @NonNull AnnotationValue<ValidUserRegistration> annotationMetadata,
                           @NonNull ConstraintValidatorContext context) {

        BeanContext beanContext = BeanContext.run();

        SomeService someService = beanContext.getBean(SomeService.class);

        someService.logUserName(value.username);

        return true;
    }

}
