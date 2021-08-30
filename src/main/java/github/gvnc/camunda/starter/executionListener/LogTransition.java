package github.gvnc.camunda.starter.executionListener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.Expression;

@Slf4j
public class LogTransition implements ExecutionListener {

    private Expression myVariable;

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        log.info("Transition passed with myVariable={}", myVariable.getExpressionText());
    }

    public Expression getMyVariable() {
        return myVariable;
    }

    public void setMyVariable(Expression myVariable) {
        this.myVariable = myVariable;
    }
}
