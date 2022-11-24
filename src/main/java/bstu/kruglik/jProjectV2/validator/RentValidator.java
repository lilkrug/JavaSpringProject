package bstu.kruglik.jProjectV2.validator;

import bstu.kruglik.jProjectV2.models.OrderForm;
import bstu.kruglik.jProjectV2.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        OrderForm scooter =(OrderForm)o;
        if(scooter.getId()<0){
            errors.rejectValue("id","negative value");
        }
    }
}
