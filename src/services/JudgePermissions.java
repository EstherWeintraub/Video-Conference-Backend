package services;

import enums.Permissions;
import enums.Role;
import io.skai.template.enums.budgetoversight.Permissions;
import io.skai.template.enums.budgetoversight.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class JudgePermissions implements ParticipantPermissions {

    @Override
    public Role getRole() {
        return Role.JUDGE;
    }

    @Override
    public Permissions getPermissions() {
        return Permissions.ADMIN;
    }
}