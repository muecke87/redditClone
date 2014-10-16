package ejb;

public class CommentBean {
	private String comment;

	public String getComment(){
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void reset() {
		this.comment = "";
	}
}
