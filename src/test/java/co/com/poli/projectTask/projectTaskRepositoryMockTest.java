package co.com.poli.projectTask;


import co.com.poli.projectTask.domain.ProjectTask;
import co.com.poli.projectTask.model.ProjectTaskStatus;
import co.com.poli.projectTask.repository.IProjectTaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EnumType;
import java.util.Date;
import java.util.List;

@DataJpaTest
public class projectTaskRepositoryMockTest {

    @Autowired
    private IProjectTaskRepository projectTaskRepository;

    @Test
    public void when_Insert_projectTask_then_ReturnListProjectTask(){
        ProjectTask projectTask =new ProjectTask();
        projectTask.setId(1L);
        projectTask.setName("Tarea 1");
        projectTask.setSummary("Sumario");
        projectTask.setAcceptanceCriteria("Bueno");
        projectTask.setStatus(ProjectTaskStatus.IN_PROGRESS);
        projectTask.setPriority(1);
        projectTask.setHours(4D);
        projectTask.setStartDate(new Date());
        projectTask.setEndDate(new Date());
        projectTask.setProjectIdentifier("ABC123");
        projectTask.setBacklog(null);

        projectTaskRepository.save(projectTask);

        List<ProjectTask> projectTaskList= projectTaskRepository.findAll();

        Assertions.assertThat(projectTaskList.size()).isEqualTo(1);

    }
}
