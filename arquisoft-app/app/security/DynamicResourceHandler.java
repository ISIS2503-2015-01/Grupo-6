package security;

import play.mvc.Http;

/**
 * Implementations of this interface are used to process dynamic restrictions (both from the view and the controller). A
 * good system to use is to have a single DynamicResourceHandler returned from your {@link DeadboltHandler} which in turn
 * delegates the isAllowed call to a an inner DynamicResourceHandler specific to the restriction name, e.g.
 * <p/>
 * public class MyDynamicResourceHandler
 * {
 * private static final Map&lt;String, DynamicResourceHandler&gt; HANDLERS = new HashMap&lt;String, DynamicResourceHandler&gt;();
 * <p/>
 * static
 * {
 * HANDLERS.put("foo",
 * new DynamicResourceHandler()
 * {
 * public boolean isAllowed(String name,
 * String meta,
 * DeadboltHandler deadboltHandler)
 * {
 * // something specific to foo
 * }
 * });
 * // repeat for your other dynamic restrictions
 * }
 * <p/>
 * public boolean isAllowed(String name,
 * String meta,
 * DeadboltHandler deadboltHandler)
 * {
 * return HANDLERS.get(name).isAllowed(name, meta, deadboltHandler);
 * }
 * <p/>
 * }
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
public interface DynamicResourceHandler
{
    /**
     * Check the access of the named resource.
     *
     * @param name            the resource name
     * @param meta            additional information on the resource
     * @param deadboltHandler the current {@link DeadboltHandler}
     * @param ctx             the context of the current request
     * @return true if access to the resource is allowed, otherwise false
     */
    boolean isAllowed(String name,
                      String meta,
                      DeadboltHandler deadboltHandler,
                      Http.Context ctx);

    /**
     * Invoked when a custom pattern needs checking..
     *
     * @param permissionValue the permission value
     * @param deadboltHandler the current {@link DeadboltHandler}
     * @param ctx the context of the current request
     * @return true if access based on the permission is  allowed, otherwise false
     */
    boolean checkPermission(String permissionValue,
                            DeadboltHandler deadboltHandler,
                            Http.Context ctx);
}