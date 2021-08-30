package github.gvnc.camunda.starter.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CamundaService {

    @Autowired
    private FormService formService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    public List<ProcessInstance> getRunningProcessInstanceList(){
        try {
            List<ProcessInstance> runningProcessList = runtimeService.createProcessInstanceQuery().active().list();
            log.info("Running process list count is {}", runningProcessList.size());
            return runningProcessList;
        }catch (Exception e){
            log.error("Failed to get running process instance list.", e);
            return null;
        }
    }

    public ProcessInstance startProcessInstanceByKey(String key){
        try {
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
            log.info("New process instance initiated. Process instance id is {}", processInstance.getId());
            return processInstance;
        }catch (Exception e){
            log.error("Failed to start process instance.", e);
            return null;
        }
    }
}
