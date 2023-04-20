package services;

import enums.Permissions;
import enums.Role;
import io.skai.template.enums.budgetoversight.Permissions;
import io.skai.template.enums.budgetoversight.Role;

public interface ParticipantPermissions {

    Role getRole();
    Permissions getPermissions();
}
