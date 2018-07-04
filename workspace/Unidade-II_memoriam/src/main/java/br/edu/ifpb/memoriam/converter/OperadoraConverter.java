package br.edu.ifpb.memoriam.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.memoriam.entity.Operadora;

@FacesConverter("OperadoraConverter")
public class OperadoraConverter  extends SelectItemsBaseConverter{

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof Operadora)
			return ((Operadora) value).getId().toString();
		else
			return null;
	}

}
