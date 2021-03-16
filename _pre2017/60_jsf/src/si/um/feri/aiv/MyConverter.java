package si.um.feri.aiv;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("ResultConverter")
public class MyConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent ui, String st) {
		return new Result(st,0);
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent ui, Object o) {
		if (o!=null && o instanceof Result) {
			Result r=(Result)o;
			return r.getCalc();
		}
		return null;
	}

}
