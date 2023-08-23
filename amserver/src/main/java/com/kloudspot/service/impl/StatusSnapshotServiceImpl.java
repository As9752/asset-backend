package com.kloudspot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloudspot.exception.StatusSnapshotNotFoundException;
import com.kloudspot.mapper.StatusSnapshotMapper;
import com.kloudspot.model.StatusSnapshot;
import com.kloudspot.model.record.StatusSnapshotRecord;
import com.kloudspot.repository.StatusSnapshotRepository;
import com.kloudspot.service.IStatusSnapshot;

@Service
public class StatusSnapshotServiceImpl implements IStatusSnapshot {

	@Autowired
	StatusSnapshotRepository statusSnapshotRepository;

	@Autowired
	private StatusSnapshotMapper statussnapShotMapper;

	@Override
	public List<StatusSnapshotRecord> getAllStatusSnapshot() {
		List<StatusSnapshot> statussnapShots = statusSnapshotRepository.findAll();
		List<StatusSnapshotRecord> statussnapShotRecords = convertToList(statussnapShots);
		return statussnapShotRecords;
	}

	private List<StatusSnapshotRecord> convertToList(List<StatusSnapshot> statussnapShots) {

		return statussnapShots.stream()
				.map((statussnapShot) -> statussnapShotMapper.convertToStatusSnapShotRecord(statussnapShot)).toList();

	}

	@Override
	public StatusSnapshotRecord getStatusSnapshotById(String statusSnapshotId) throws StatusSnapshotNotFoundException {
		StatusSnapshot statussnapShot = statusSnapshotRepository.findById(statusSnapshotId)
				.orElseThrow(() -> new StatusSnapshotNotFoundException("SnapShot of this id is not present"));
		return statussnapShotMapper.convertToStatusSnapShotRecord(statussnapShot);
	}

	@Override
	public StatusSnapshotRecord addStatusSnapshot(StatusSnapshotRecord statusSnapshotRecord) {
		StatusSnapshot addedStatusSnapShot = statusSnapshotRepository
				.save(statussnapShotMapper.convertToStatusSnapShot(statusSnapshotRecord));
		return statussnapShotMapper.convertToStatusSnapShotRecord(addedStatusSnapShot);
	}

	@Override
	public StatusSnapshotRecord updateStatusSnapshot(String statusSnapshotId, StatusSnapshotRecord statusSnapshotRecord)
			throws StatusSnapshotNotFoundException {
		StatusSnapshot statusSnapShot = statusSnapshotRepository.findById(statusSnapshotId)
				.orElseThrow(() -> new StatusSnapshotNotFoundException("StatusSnapShot with given id not found"));
		statusSnapShot.setAsset(statusSnapshotRecord.asset());
		statusSnapShot.setLocation(statusSnapshotRecord.location());
		statusSnapShot.setMeta(statusSnapshotRecord.meta());
		statusSnapShot.setStatus(statusSnapshotRecord.status());
		statusSnapShot.setStatusSnapshotId(statusSnapshotRecord.statusSnapshotId());
		statusSnapShot.setTimestamp(statusSnapshotRecord.timestamp());
		statusSnapShot.setUserId(statusSnapshotRecord.userId());

		StatusSnapshot updatedSnapShot = statusSnapshotRepository.save(statusSnapShot);
		return statussnapShotMapper.convertToStatusSnapShotRecord(updatedSnapShot);
	}

	@Override
	public void deleteStatusSnapshot(String statusSnapshotId) {
		// TODO Auto-generated method stub
		statusSnapshotRepository.deleteById(statusSnapshotId);
	}

}
