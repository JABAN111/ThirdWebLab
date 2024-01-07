package validatorBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validatorButtonX")
@ManagedBean
@RequestScoped
public class validatorButtonY implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try {
            double yNum = Double.parseDouble(String.valueOf(value));

            if (!(yNum >= -3 && yNum <= 5)) {
                FacesMessage message = new FacesMessage("y должен быть в диапазоне [-3;5]\n" +
                        "Введенное значение: " + value);
                throw new ValidatorException(message);
            }
        } catch (NumberFormatException e) {
            FacesMessage message = new FacesMessage("Введите ЧИСЛО в диапазоне [-3;5]");
            throw new ValidatorException(message);
        }
    }
}