package ejb;

public class LinkBean {
	private String title;
	private String url;	
	boolean showcomments = false;	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean getShowcomments() {
		return showcomments;
	}
	
	public void changeShowcomments() {
		if(showcomments)showcomments=false;
		else showcomments=true;
	}

}
