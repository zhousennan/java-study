package com.zsn.springactiviti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/30  17:23
 */
@SpringBootTest
public class Test {
    @Resource
    private RuntimeService runtimeService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private TaskService taskService;

    @org.junit.jupiter.api.Test
    void contextLoads() {
        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> definitionList;


        definitionList = definitionQuery.list();

    }
}
