package com.kloudspot.mapper;

import org.springframework.stereotype.Component;

import com.kloudspot.model.StatusSnapshot;
import com.kloudspot.model.record.StatusSnapshotRecord;

@Component
public class StatusSnapshotMapper {
	public StatusSnapshot convertToStatusSnapShot(StatusSnapshotRecord snapshotRecord) {
		StatusSnapshot statussnapShot = new StatusSnapshot();
		statussnapShot.setAsset(snapshotRecord.asset());
		statussnapShot.setLocation(snapshotRecord.location());
		statussnapShot.setMeta(snapshotRecord.meta());
		statussnapShot.setStatus(snapshotRecord.status());
		statussnapShot.setStatusSnapshotId(snapshotRecord.statusSnapshotId());
		statussnapShot.setTimestamp(snapshotRecord.timestamp());
		statussnapShot.setUserId(snapshotRecord.userId());
		return statussnapShot;

	}

	public StatusSnapshotRecord convertToStatusSnapShotRecord(StatusSnapshot statusSnapshot) {
		StatusSnapshotRecord statusSnapShotRecord = new StatusSnapshotRecord(statusSnapshot.getStatusSnapshotId(),
				statusSnapshot.getAsset(), statusSnapshot.getStatus(), statusSnapshot.getMeta(),
				statusSnapshot.getTimestamp(), statusSnapshot.getLocation(), statusSnapshot.getUserId());
		return statusSnapShotRecord;
	}
}
