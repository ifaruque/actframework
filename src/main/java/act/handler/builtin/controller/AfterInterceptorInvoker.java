package act.handler.builtin.controller;

import act.Destroyable;
import act.app.AppContext;
import act.util.Prioritised;
import org.osgl.mvc.result.Result;

public interface AfterInterceptorInvoker extends Prioritised, Destroyable {
    Result handle(Result result, AppContext appContext);
    void accept(ActionHandlerInvoker.Visitor visitor);
}
