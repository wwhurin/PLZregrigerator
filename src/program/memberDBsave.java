package program;

public class memberDBsave {
	private String id;//아이디
	private String pass;//비밀번호
	private String nick;//닉네임 
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}



	@Override
	public String toString() {
		return "memberDBsave [id=" + id + ", pass=" + pass + ", nick=" + nick
				+ "]";
	}


	

}
