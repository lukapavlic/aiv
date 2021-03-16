package si.um.feri.aiv;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("PlusValidator")
public class MyValidator implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent ui, Object o) throws ValidatorException {
		if (o==null) return;
		String s=o.toString();
		
		if (!s.contains("+")) throw new ValidatorException(new FacesMessage("String should include + sign."));
		
	}
}
