package model;

/**
 * A role that can be held by a {@link Subject}.  Checks should done on the name of the role, not using object equality
 * on the Role itself.
 *
 * @see be.objectify.deadbolt.core.models.Subject#getRoles()
 * @author Steve Chaloner (steve@objectify.be)
 */
public interface Role
{
    /**
     * Get the name of the role.
     *
     * @return the non-null name of the role
     */
    String getName();
}