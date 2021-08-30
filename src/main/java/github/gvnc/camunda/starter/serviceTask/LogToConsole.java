package github.gvnc.camunda.starter.serviceTask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Slf4j
public class LogToConsole implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String someVariable = (String)delegateExecution.getVariable("someVariable");
        log.info("someVariable={}", someVariable);
        someVariable = someVariable + "-postfix";
        delegateExecution.setVariable("someVariable", someVariable);
    }
}
