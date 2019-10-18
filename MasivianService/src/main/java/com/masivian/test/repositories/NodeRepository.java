package com.masivian.test.repositories;

import com.masivian.test.entities.Node;
import com.masivian.test.entities.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * This interface defines the methods to manage the node entity.
 * @author Anderson Vega
 */
public interface NodeRepository extends JpaRepository<Node, Long> {
    
    @Query("SELECT nod FROM Node nod WHERE nod.tree=(:tree) AND nod.nodeValue = (:nodeValue)")
    public Node findByNodeValue(@Param("tree") Tree tree,
            @Param("nodeValue") Integer nodeValue);
    
    @Query("SELECT nod FROM Node nod WHERE nod.tree=(:tree) AND "
            + "(nod.leftNodeValue = (:nodeValue) OR nod.rightNodeValue = (:nodeValue))")
    public Node findByDecendantNode(@Param("tree") Tree tree,
            @Param("nodeValue") Integer nodeValue);
}
