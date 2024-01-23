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
public class validatorButtonX implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Double xNum = (Double) value;
        if(!(xNum >= -4.0 && xNum <= 4.0)){
            FacesMessage message = new FacesMessage("Не валидный x, значение x должно быть в диапозоне [-4;4]");
            throw new ValidatorException(message);
        }
    }
}
