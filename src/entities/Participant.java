package entities;

import enums.Permissions;
import enums.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Participant {
    long id;
    String name;
    Role role;
    Permissions permissions;
}
