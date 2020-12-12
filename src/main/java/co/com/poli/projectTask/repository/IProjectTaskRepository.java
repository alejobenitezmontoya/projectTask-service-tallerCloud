package co.com.poli.projectTask.repository;


import co.com.poli.projectTask.domain.ProjectTask;
import co.com.poli.projectTask.model.ProjectTaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectTaskRepository extends JpaRepository<ProjectTask,Long> {

    List<ProjectTask> findProjectTasksByProjectIdentifier(String projectIdenfifier);
    List<ProjectTask> findProjectTasksByProjectIdentifierAndStatus(String projectIdenfifier, ProjectTaskStatus status);
    ProjectTask findProjectTasksByIdAndProjectIdentifier(Long id, String projectIdentifier);
}
