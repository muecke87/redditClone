package web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ejb.RedditBean;

public class UsernameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		RedditBean redditBean = (RedditBean)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("redditBean");
		List<User> users = redditBean.getUsers();
		
		String username = (String)value;
		
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				//nameComponent.setValid(false); // So that it's marked invalid.
				System.out.println("UserValidator");
				throw new ValidatorException(new FacesMessage("Username already exists."));
			}
		}
	}

}