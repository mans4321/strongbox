package org.carlspring.strongbox.users.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.annotation.concurrent.Immutable;

import org.carlspring.strongbox.users.dto.UserPathPrivelegiesReadContract;
import org.carlspring.strongbox.users.dto.UserPathPrivilegesDto;

/**
 * @author Przemyslaw Fusik
 */
@Immutable
public class AccessModelPathPrivileges
        implements Serializable, UserPathPrivelegiesReadContract
{

    private final String path;

    /**
     *  If true, allows to set privileges within path and all subdirectories
     */
    private final boolean wildcard;

    private final Set<Privileges> privileges;

    public AccessModelPathPrivileges(final UserPathPrivilegesDto delegate)
    {
        this.path = delegate.getPath();
        this.wildcard = delegate.isWildcard();
        this.privileges = immutePrivileges(delegate.getPrivileges());
    }


    private Set<Privileges> immutePrivileges(final Set<Privileges> source)
    {
        return source != null ?
               Collections.unmodifiableSet(source) :
               Collections.emptySet();
    }

    public String getPath()
    {
        return path;
    }

    public boolean isWildcard()
    {
        return wildcard;
    }

    public Set<Privileges> getPrivileges()
    {
        return privileges;
    }
}
