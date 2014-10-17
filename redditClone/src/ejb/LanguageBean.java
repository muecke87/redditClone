package ejb;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class LanguageBean {

	private String localeCode;
	 
	private static Map<String, Object> countries;
	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH); 
		countries.put("Deutsch", Locale.GERMAN);
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public void countryLocaleCodeChanged(ValueChangeEvent e) {

		String newLocaleValue = e.getNewValue().toString();

		for (Map.Entry<String, Object> entry : countries.entrySet()) {

			if (entry.getValue().toString().equals(newLocaleValue)) {

				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());

			}
		}
	}	
}
