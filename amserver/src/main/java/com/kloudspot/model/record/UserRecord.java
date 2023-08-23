package com.kloudspot.model.record;

import com.kloudspot.model.Roles;

public record UserRecord(String userId, String name, Roles roles, String userEmail) {

}
