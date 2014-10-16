package ejb;

import javax.faces.context.FacesContext;

import web.User;


public class LoginBean {
	
	private String username;
	private String password;
	
	private boolean loggedIn = false;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public void doLogin() {
		RedditBean redditCloneBean = (RedditBean)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("redditBean");
		for (User user : redditCloneBean.getUsers()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				setLoggedIn(true);
				
				return;
			}
		}
		setUsername("");
		setLoggedIn(false);
	}
	
	public void doLogout() {
		setUsername("");
		setPassword("");
        setLoggedIn(false);
    }
	
	
	public void register() {
		RedditBean redditCloneBean = (RedditBean)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("redditBean");
		User newUser = new User();
		newUser.setUsername(this.getUsername());
		newUser.setPassword(this.getPassword());
		redditCloneBean.addUser(newUser);
		this.setLoggedIn(true);
		redditCloneBean.setShowRegister(false);
	}
	
	public void hideRegister() {
		RedditBean redditCloneBean = (RedditBean)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("redditBean");
		redditCloneBean.setShowRegister(false);
	}
}		