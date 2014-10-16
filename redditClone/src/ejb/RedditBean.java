package ejb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import web.Comment;
import web.Link;
import web.User;

public class RedditBean {
	private LinkedList<Link> linklist = new LinkedList<Link>();
	private ArrayList<User> users = new ArrayList<User>();
	boolean submitlink = false;
	private boolean showRegister = false;
	private int commentid=1000;
	
	public RedditBean() {
		init();
	}
	
	public void init() {
		users.add(new User("muecke", "123"));
		users.add(new User("sirLoaf" , "123"));
		
		Link one = new Link("watch baseball", "www.mlb.tv", "muecke");
		Link two = new Link("businesscat is funny", "http://www.businesscat.happyjar.com", "sirLoaf");
		Link three = new Link("all you can eat", "http://www.a-discretion.ch/", "sirLoaf");
		Link four = new Link("learn cpp", "http://www.cplusplus.com/doc/tutorial/", "muecke");
				
		Comment cb1 = new Comment("der erste Kommentar" , "muecke", 10);
		Comment cb2 = new Comment("der zweite Kommentar" , "sirLoaf", 11);		
		one.getCommentlist().add(cb1);
		one.getCommentlist().add(cb2);	
		
		linklist.add(one);
		linklist.add(two);
		linklist.add(three);
		linklist.add(four);
	}
	
	public boolean getSubmitlink() {
		return submitlink;
	}
	
	public void changeSubmitLink() {
		if(submitlink)submitlink=false;
		else submitlink=true;
	}
	
	public void disableSubmitLink() {
		submitlink = false;
	}
	
	public void addLink(String title, String url, String user) {
		linklist.addFirst(new Link(title,url,user));
	}
	
	public void addComment(Link link, String comment, String user) {
		commentid++;
		link.getCommentlist().addFirst(new Comment(comment,user,commentid));
	}
	
	public LinkedList<Link> getLinklist() {
		return linklist;
	}
	
	public void setShowRegister(boolean showRegister) {
		this.showRegister = showRegister;
	}
	
	public void hideRegister() {
		showRegister = false;
	}
	
	public boolean isShowRegister() {
		return showRegister;
	}
	
	public void doShowRegister() {
		showRegister = true;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void addUser(User newUser) {
		users.add(newUser);
	}
}
