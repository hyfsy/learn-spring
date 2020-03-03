package com.hyf.spring3.validator;

import com.hyf.spring3.pojo.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author baB_hyf
 * @date 2020/02/25
 */
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // 判断clazz是否为Person类型或其子类
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // 校验是否为空
        ValidationUtils.rejectIfEmpty(errors, "id", "error_code_id");

        // 校验是否有文本
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error_code_name");

        if (person.getAge() > 20) {
            // 设置一个错误
            errors.rejectValue("age", "error_code_age");
        }
    }
}
