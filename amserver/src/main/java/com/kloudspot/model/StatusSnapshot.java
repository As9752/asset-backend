package com.kloudspot.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StatusSnapshot {

	@Id
	private String statusSnapshotId;

	@DBRef
	private Asset asset;

	private AssetStatus status;
	private Map<String, Object> meta; // Consider using a Map or a custom class

	private Date timestamp;

	@DBRef
	private AssetLocation location;

	@DBRef
	private User userId;

	public StatusSnapshot() {
		super();
	}

	public StatusSnapshot(String statusSnapshotId, Asset asset, AssetStatus status, Map<String, Object> meta,
			Date timestamp, AssetLocation location, User userId) {
		super();
		this.statusSnapshotId = statusSnapshotId;
		this.asset = asset;
		this.status = status;
		this.meta = meta;
		this.timestamp = timestamp;
		this.location = location;
		this.userId = userId;
	}

	public String getStatusSnapshotId() {
		return statusSnapshotId;
	}

	public void setStatusSnapshotId(String statusSnapshotId) {
		this.statusSnapshotId = statusSnapshotId;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public AssetStatus getStatus() {
		return status;
	}

	public void setStatus(AssetStatus status) {
		this.status = status;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public AssetLocation getLocation() {
		return location;
	}

	public void setLocation(AssetLocation location) {
		this.location = location;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

}
