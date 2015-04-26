package security;

import model.Subject;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

/**
 * Abstract implementation of {@link DeadboltHandler} that gives a standard unauthorised result when access fails.
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
public abstract class AbstractDeadboltHandler extends Results implements DeadboltHandler
{
    /**
     * {@inheritDoc}
     */
    public Subject getSubject(final Http.Context context)
    {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public F.Promise<Result> onAuthFailure(final Http.Context context,
                                           final String content)
    {
        return F.Promise.promise(new F.Function0<Result>()
        {
            @Override
            public Result apply() throws Throwable
            {
                return unauthorized(views.html.defaultpages.unauthorized.render());
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    public DynamicResourceHandler getDynamicResourceHandler(final Http.Context context)
    {
        return null;
    }
}