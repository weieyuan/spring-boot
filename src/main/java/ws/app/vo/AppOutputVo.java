package ws.app.vo;

public class AppOutputVo {

	private boolean success;

	private String message;

	public AppOutputVo() {

	}

	public AppOutputVo(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
