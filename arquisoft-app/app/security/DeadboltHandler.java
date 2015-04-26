package security;

import model.Subject;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;

/**
 * DeadboltHandler implementations are the main hook into the Deadbolt system.  Here, you can apply authentication
 * checks using {@link DeadboltHandler#beforeAuthCheck}, get the current user, decide what to do when access fails and
 * provide implementations for dynamic be.objectify.deadbolt.java.test.security.
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
public interface DeadboltHandler {

    /**
     * Invoked immediately before controller or view restrictions are checked. This forms the integration with any
     * authentication actions that may need to occur.
     *
     * @param context the HTTP context
     * @return the action result if an action other than the delegate must be taken, otherwise null. For a case where
     *         the user is authenticated (or whatever your test condition is), this will be null otherwise the restriction
     *         won't be applied.
     */
    F.Promise<Result> beforeAuthCheck(Http.Context context);

    /**
     * Gets the current {@link be.objectify.deadbolt.core.models.Subject}, e.g. the current user.
     *
     * @param context the HTTP context
     * @return the current subject
     */
    Subject getSubject(Http.Context context);

    /**
     * Invoked when an access failure is detected on <i>controllerClassName</i>.
     *
     * @param context the HTTP context
     * @param content the content type hint.  This can be used to return a response in the appropriate content
     *                type, e.g. JSON
     * @return the action result
     */
    F.Promise<Result> onAuthFailure(Http.Context context,
                                    String content);

    /**
     * Gets the handler used for dealing with resources restricted to specific users/groups.
     *
     * @param context the HTTP context
     * @return the handler for restricted resources. May be null.
     */
    DynamicResourceHandler getDynamicResourceHandler(Http.Context context);
}
