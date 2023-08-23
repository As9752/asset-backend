package com.kloudspot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kloudspot.exception.StatusSnapshotNotFoundException;
import com.kloudspot.model.record.StatusSnapshotRecord;
import com.kloudspot.service.IStatusSnapshot;

@RestController
@RequestMapping("/api/v1/status-snapshots")
public class StatusSnapshotController {

	@Autowired
	private IStatusSnapshot statusSnapshotService;

	@GetMapping
	public ResponseEntity<List<StatusSnapshotRecord>> getAllStatusSnapshots() {
		return new ResponseEntity<>(statusSnapshotService.getAllStatusSnapshot(), HttpStatus.OK);
	}

	@GetMapping("/{statusSnapshotId}")
	public ResponseEntity<StatusSnapshotRecord> getStatusSnapshotById(@PathVariable String statusSnapshotId)
			throws StatusSnapshotNotFoundException {
		return new ResponseEntity<>(statusSnapshotService.getStatusSnapshotById(statusSnapshotId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<StatusSnapshotRecord> createStatusSnapshot(@RequestBody StatusSnapshotRecord statusSnapshot) {
		return new ResponseEntity<>(statusSnapshotService.addStatusSnapshot(statusSnapshot), HttpStatus.CREATED);
	}

	@PutMapping("/{statusSnapshotId}")
	public ResponseEntity<StatusSnapshotRecord> updateStatusSnapshot(@PathVariable String statusSnapshotId,
			@RequestBody StatusSnapshotRecord statusSnapshot) throws StatusSnapshotNotFoundException {
		return new ResponseEntity<>(statusSnapshotService.updateStatusSnapshot(statusSnapshotId, statusSnapshot),
				HttpStatus.OK);
	}

	@DeleteMapping("/{statusSnapshotId}")
	public ResponseEntity<Void> deleteStatusSnapshot(@PathVariable String statusSnapshotId) {
		statusSnapshotService.deleteStatusSnapshot(statusSnapshotId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
