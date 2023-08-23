package com.kloudspot.DTO;

import java.util.List;

import com.kloudspot.model.record.UserRecord;

public class UserListWrapper {
	private List<UserRecord> data;

	public List<UserRecord> getData() {
		return data;
	}

	public void setData(List<UserRecord> data) {
		this.data = data;
	}
}