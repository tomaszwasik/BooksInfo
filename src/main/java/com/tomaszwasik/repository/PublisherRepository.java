package com.tomaszwasik.repository;

import com.tomaszwasik.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
public interface PublisherRepository extends JpaRepository<PublisherEntity, Long>{
}
