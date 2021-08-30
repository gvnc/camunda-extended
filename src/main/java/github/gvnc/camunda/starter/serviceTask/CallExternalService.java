package github.gvnc.camunda.starter.serviceTask;

import github.gvnc.camunda.starter.service.ExternalService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Slf4j
@Named(value="CallExternalService")
public class CallExternalService implements JavaDelegate {

    @Autowired
    private ExternalService externalService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if(externalService.doSomething() == true){
            delegateExecution.setVariable("someVariable", "testing");
            log.info("External service call is successful.");
        }
    }
}
