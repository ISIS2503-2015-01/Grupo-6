package security;

import security.DeadboltAnalyzer;
import play.mvc.Http;

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
public class JavaDeadboltAnalyzer extends DeadboltAnalyzer
{
    /**
     * Checks a custom pattern using the {@link be.objectify.deadbolt.java.DynamicResourceHandler} obtained via the handler.
     *
     * @param handler the handler
     * @param context the context
     * @param value the pattern value
     * @return true iff the custom check succeeds
     */
    public boolean checkCustomPattern(final DeadboltHandler handler,
                                      final Http.Context context,
                                      final String value)
    {
        boolean patternOk = false;

        DynamicResourceHandler dynamicResourceHandler = handler.getDynamicResourceHandler(context);
        if (dynamicResourceHandler == null)
        {
            throw new RuntimeException("A custom permission type is specified but no dynamic resource handler is provided");
        }
        else
        {
            patternOk = dynamicResourceHandler.checkPermission(value,
                                                               handler,
                                                               context);
        }

        return patternOk;
    }
}