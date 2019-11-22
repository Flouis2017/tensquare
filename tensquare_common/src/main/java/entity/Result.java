package entity;

import enumeration.StateCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {

	private Boolean flag;
	private Integer code;
	private String message;
	private Object data;

	public static Result success(){
		return new Result(true, StateCode.SUCCESS.getCode(), StateCode.SUCCESS.getMsg(), null);
	}

	public static Result success(String message){
		return new Result(true, StateCode.SUCCESS.getCode(), message, null);
	}

	public static Result success(Object data){
		return new Result(true, StateCode.SUCCESS.getCode(), StateCode.SUCCESS.getMsg(), data);
	}

	public static Result success(String message, Object data){
		return new Result(true, StateCode.SUCCESS.getCode(), message, data);
	}

	public static Result fail(){
		return new Result(false, StateCode.FAIL.getCode(), StateCode.FAIL.getMsg(), null);
	}

	public static Result fail(String message){
		return new Result(false, StateCode.FAIL.getCode(), message, null);
	}

}
