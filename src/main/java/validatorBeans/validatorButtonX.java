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
        Integer xNum = (Integer) value;
        if(!(xNum >= -4 && xNum <= 4)){
            FacesMessage message = new FacesMessage("Не валидный x");
            throw new ValidatorException(message);
        }
    }
}
