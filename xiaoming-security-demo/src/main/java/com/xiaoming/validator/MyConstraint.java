package com.xiaoming.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义注解
 * @author 江小明
 *
 */
@Target({ElementType.METHOD, ElementType.FIELD})	//表示这个注解可以标记在哪个元素上面
@Retention(RetentionPolicy.RUNTIME)		//运行时注解
@Constraint(validatedBy = MyConstraintValidator.class)		//当前注解使用某个类去注解
public @interface MyConstraint {
	//下面三个属性都是必须
	String message(); //校验错误信息

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
