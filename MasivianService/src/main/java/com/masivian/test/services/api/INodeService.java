package com.masivian.test.services.api;

import com.masivian.test.entities.NodeResponse;

/**
 * Nodes service interface.
 * @author Anderson Vega
 */
public interface INodeService {
    
    /**
     * Method to get the lowest ancestor from two nodes.
     *
     * @param treeId tree indentifier.
     * @param firstNodeValue first node to evaluate.
     * @param secondNodeValue second node to evaluate.
     * @return the nearest ancestor from two nodes.
     * @throws java.lang.Exception
     */
    public NodeResponse getLowestCommonAncestor(Long treeId, 
            Integer firstNodeValue, Integer secondNodeValue) throws Exception;
}
