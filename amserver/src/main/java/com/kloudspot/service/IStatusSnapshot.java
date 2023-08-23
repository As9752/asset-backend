package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.StatusSnapshotNotFoundException;
import com.kloudspot.model.record.StatusSnapshotRecord;

public interface IStatusSnapshot {
	public List<StatusSnapshotRecord> getAllStatusSnapshot();

	public StatusSnapshotRecord getStatusSnapshotById(String statusSnapshotId) throws StatusSnapshotNotFoundException;

	public StatusSnapshotRecord addStatusSnapshot(StatusSnapshotRecord statusSnapshotRecord);

	public StatusSnapshotRecord updateStatusSnapshot(String statusSnapshotId, StatusSnapshotRecord statusSnapshotRecord)
			throws StatusSnapshotNotFoundException;

	public void deleteStatusSnapshot(String statusSnapshotId);

}
