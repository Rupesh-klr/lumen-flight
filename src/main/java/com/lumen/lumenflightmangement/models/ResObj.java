package com.lumen.lumenflightmangement.models;

public class ResObj {
	String message;
	Object data;
	int status;

	public ResObj() {
	}

	public ResObj(String message) {
		this.message = message;
		this.data ="failed request";
		this.status=-1;
	}
	public ResObj(Object data) {
		this.status=1;
		this.message ="Successfully request.";
		this.data = data;
	}

	public ResObj(String message, Object data, int status) {
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "{" +
				"message='" + message + '\'' +
				", data=" + data +
				", status=" + status +
				'}';
	}
}
