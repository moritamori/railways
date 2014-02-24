package net.bitpot.railways.models.routes;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * @author Basil Gren
 */
public abstract class RequestType {
    public static final RequestType GET = new GetRequestType();
    public static final RequestType POST = new PostRequestType();
    public static final RequestType PUT = new PutRequestType();
    public static final RequestType PATCH = new PatchRequestType();
    public static final RequestType DELETE = new DeleteRequestType();
    public static final RequestType ANY = new AnyRequestType();


    private static List<RequestType> routeTypes = createRouteTypesList();


    private static List<RequestType> createRouteTypesList() {
        Vector<RequestType> types = new Vector<RequestType>();
        types.add(GET);
        types.add(POST);
        types.add(PUT);
        types.add(PATCH);
        types.add(DELETE);
        types.add(ANY);

        return types;
    }


    /**
     * Finds request type by name. If no request type is found, AnyRequestType is
     * returned.
     *
     * @param name Name of request type.
     * @return RequestType object.
     */
    @NotNull
    public static RequestType get(String name) {
        for(RequestType type: routeTypes)
            if (type.getName().equals(name))
                return type;

        return ANY;
    }


    /**
     * Returns the icon used for showing routes of the type.
     *
     * @return The icon instance, or null if no icon should be shown.
     */
    public abstract Icon getIcon();

    /**
     * Returns the name of the route type. The name must be unique among all route types.
     *
     * @return The route type name.
     */
    @NotNull
    @NonNls
    public abstract String getName();


    public static Collection<RequestType> getAllRequestTypes() {
        return routeTypes;
    }
}
