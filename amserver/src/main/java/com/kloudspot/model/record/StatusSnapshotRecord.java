package com.kloudspot.model.record;

import java.util.Date;
import java.util.Map;

import com.kloudspot.model.Asset;
import com.kloudspot.model.AssetLocation;
import com.kloudspot.model.AssetStatus;
import com.kloudspot.model.User;

public record StatusSnapshotRecord(String statusSnapshotId, Asset asset, AssetStatus status, Map<String, Object> meta,
		Date timestamp, AssetLocation location, User userId) {

}
