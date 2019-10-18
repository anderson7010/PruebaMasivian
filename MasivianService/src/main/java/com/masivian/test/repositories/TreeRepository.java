package com.masivian.test.repositories;

import com.masivian.test.entities.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines the methods to manage the tree entity.
 * @author Anderson Vega
 */
public interface TreeRepository extends JpaRepository<Tree, Long> {
}
