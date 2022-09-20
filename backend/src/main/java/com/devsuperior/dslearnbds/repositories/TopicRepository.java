package com.devsuperior.dslearnbds.repositories;

import com.devsuperior.dslearnbds.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
