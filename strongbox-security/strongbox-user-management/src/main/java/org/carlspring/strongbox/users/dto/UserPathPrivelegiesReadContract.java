package org.carlspring.strongbox.users.dto;

import java.util.Set;

import org.carlspring.strongbox.users.domain.Privileges;

public interface UserPathPrivelegiesReadContract
{

    String getPath();

    boolean isWildcard();

    Set<Privileges> getPrivileges();

}
