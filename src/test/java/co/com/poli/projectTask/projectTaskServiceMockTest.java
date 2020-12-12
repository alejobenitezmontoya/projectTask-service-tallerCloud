package co.com.poli.projectTask;


import co.com.poli.projectTask.domain.ProjectTask;
import co.com.poli.projectTask.model.ProjectTaskStatus;
import co.com.poli.projectTask.repository.IProjectTaskRepository;
import co.com.poli.projectTask.services.ProjectTaskService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class projectTaskServiceMockTest {

    @Autowired
    private IProjectTaskRepository projectTaskRepository;
    private ProjectTaskService projectTaskService;

    @Test
    public void when_Insert_ProjectTask_then_Return_AssociatedTasks(){

        ProjectTask projectTask=new ProjectTask();
        projectTask.setId(1L);
        projectTask.setName("Tarea 1");
        projectTask.setSummary("Resumen 1");
        projectTask.setAcceptanceCriteria("Bueno");
        projectTask.setStatus(ProjectTaskStatus.IN_PROGRESS);
        projectTask.setPriority(1);
        projectTask.setHours(4D);
        projectTask.setStartDate(new Date());
        projectTask.setEndDate(new Date());
        projectTask.setProjectIdentifier("ABC123");
        projectTask.setBacklog(null);

        projectTaskRepository.save(projectTask);

        projectTask.setId(12L);
        projectTask.setName("Tarea 2");
        projectTask.setSummary("Resumen 1");
        projectTask.setAcceptanceCriteria("Bueno");
        projectTask.setStatus(ProjectTaskStatus.IN_PROGRESS);
        projectTask.setPriority(2);
        projectTask.setHours(4D);
        projectTask.setStartDate(new Date());
        projectTask.setEndDate(new Date());
        projectTask.setProjectIdentifier("ABC123");
        projectTask.setBacklog(null);

        projectTaskRepository.save(projectTask);

        projectTask.setId(20L);
        projectTask.setName("Tarea 1");
        projectTask.setSummary("Resumen 1");
        projectTask.setAcceptanceCriteria("Bueno");
        projectTask.setStatus(ProjectTaskStatus.IN_PROGRESS);
        projectTask.setPriority(2);
        projectTask.setHours(4D);
        projectTask.setStartDate(new Date());
        projectTask.setEndDate(new Date());
        projectTask.setProjectIdentifier("ABC456");
        projectTask.setBacklog(null);

        projectTaskRepository.save(projectTask);

        List<ProjectTask> projectTaskList= projectTaskRepository.findProjectTasksByProjectIdentifier("ABC123");

        Assertions.assertThat(projectTaskList.size()).isEqualTo(2);


    }
}
