package com.kloudspot.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	private String message;
	private HttpStatus status;
	private LocalDateTime timestamp;
	private String error;

	public ApiErrors(String message, HttpStatus status, LocalDateTime localDateTime, String error) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = localDateTime;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ApiErrors [message=" + message + ", status=" + status + ", timestamp=" + timestamp + ", error=" + error
				+ "]";
	}

}
