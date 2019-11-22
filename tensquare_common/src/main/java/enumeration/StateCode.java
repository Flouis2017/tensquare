package enumeration;

public enum StateCode {

	SUCCESS(20000, "请求成功"),
	LOGIN_ERROR(30001, "用户名或密码错误"),
	ACCESS_ERROR(30002, "权限不足"),
	RE_ERROR(30003, "重复操作"),
	FAIL(40000, "响应失败");

	private int code;
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	StateCode(int code, String msg){
		this.setCode(code);
		this.setMsg(msg);
	}

}
