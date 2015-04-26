package security;

import play.mvc.Http;

/**
 * Stubbed implementation of {@link DynamicResourceHandler} for cases when you only need one of the two methods.
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
public abstract class AbstractDynamicResourceHandler implements DynamicResourceHandler
{
    /**
     * {@inheritDoc}
     */
    public boolean isAllowed(String name,
                             String meta,
                             DeadboltHandler deadboltHandler,
                             Http.Context ctx)
    {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkPermission(String permissionValue,
                                   DeadboltHandler deadboltHandler,
                                   Http.Context ctx)
    {
        return false;
    }
}