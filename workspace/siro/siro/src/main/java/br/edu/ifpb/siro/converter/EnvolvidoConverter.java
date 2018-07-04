package br.edu.ifpb.siro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.siro.entity.Envolvido;

@FacesConverter("EnvolvidoConverter")
public class EnvolvidoConverter  extends SelectItemsBaseConverter{

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof Envolvido)
			return ((Envolvido) value).getTelefone().toString();
		else
			return null;
	}

}
