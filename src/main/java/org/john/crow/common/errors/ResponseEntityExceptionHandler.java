package org.john.crow.common.errors;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.john.crow.common.util.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;

/**
 * @author johnconstantine
 */
@RestControllerAdvice(annotations = RestController.class)
public class ResponseEntityExceptionHandler {
    /**
     * @param e 异常为{@code MethodArgumentNotValidException}
     * @return //设置状态码为 400
     * {@code HttpStatus.BAD_REQUEST} 400 error
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class,
            BindException.class,
            ValidationException.class,
            ConstraintViolationException.class})
    public JsonResult paramExceptionHandler(Exception e) {
        if (e instanceof MethodArgumentNotValidException methodException) {
            BindingResult exceptions = methodException.getBindingResult();
            return catchException(exceptions);
        }

        if (e instanceof WebExchangeBindException webExchangeBindException) {
            BindingResult exceptions = webExchangeBindException.getBindingResult();
            return catchException(exceptions);
        }

        if (e instanceof BindException bindException) {
            BindingResult exceptions = bindException.getBindingResult();
            return catchException(exceptions);
        }

        if (e instanceof ConstraintViolationException constraintViolationException) {
            return JsonResult.errorMsg(constraintViolationException.getMessage());
        }

        return JsonResult.errorMsg(e.getMessage());
    }

    private JsonResult catchException(BindingResult exceptions) {
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return JsonResult.errorMsg(fieldError.getDefaultMessage());
            }
        }
        return JsonResult.errorMsg("请求参数错误");
    }
}
