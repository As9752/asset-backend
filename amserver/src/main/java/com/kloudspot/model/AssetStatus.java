package com.kloudspot.model;

public enum AssetStatus {
	IN_USE("In Use"), IN_REPAIR("In Repair"), ON_SITE("On Site"), IN_STORE("In Store"), ASSIGNED("Assigned");

	private final String status;

	AssetStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
