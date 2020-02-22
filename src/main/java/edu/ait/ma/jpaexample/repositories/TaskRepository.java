package edu.ait.ma.jpaexample.repositories;

import edu.ait.ma.jpaexample.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    // find all tasks matching given priority
    // List<T> contains just the contents , no info about pages is present
    List<Task> findByPriority(int priority, Sort sort);

    // find a Page of tasks matching given priority
    // Page<T> contains the total elements count.
    Page<Task> findByPriority(int priority, Pageable pageable);

    // find a Slice of tasks matching given priority
    // Slice<T> contains just the current page detail and whether there is another page
    Slice<Task> findByDescriptionLike(String description, Pageable pageable);

}
