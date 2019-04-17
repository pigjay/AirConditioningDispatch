package com.pigteam.airconditioning.common.validate.validator;

import com.pigteam.airconditioning.common.validate.annotation.ValueSet;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * 验证器
 *
 * @author zhujie
 */
public class ValueSetValidator implements ConstraintValidator<ValueSet, Object> {

    private ValueSet valueSet;

    /**
     * 初始化验证参数
     */
    @Override
    public void initialize(ValueSet valueSet) {
        this.valueSet = valueSet;
    }

    /**
     * 验证参数是否有效
     *
     * @param target 验证目标
     */
    @Override
    public boolean isValid(Object target, ConstraintValidatorContext context) {
        if (target == null) {
            return true;
        }
        if (Arrays.asList(valueSet.value()).contains(target.toString())) {
            return true;
        } else {
            String messageTemplate = context.getDefaultConstraintMessageTemplate();
            messageTemplate = MessageFormat.format(messageTemplate, Arrays.toString(valueSet.value()));
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation();
            return false;
        }

    }

}
