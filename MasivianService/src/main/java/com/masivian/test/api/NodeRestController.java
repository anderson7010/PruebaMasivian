package com.masivian.test.api;

import com.masivian.test.entities.NodeResponse;
import com.masivian.test.services.impl.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class defines the REST services to manage nodes.
 * @author Anderson Vega
 */
@RestController
@RequestMapping(value = "/node", method = RequestMethod.GET)
public class NodeRestController {
    
    @Autowired
    NodeService nodeService;
    
    /**
     * Method to get the lowest ancestor from two nodes.
     *
     * @param treeId tree indentifier.
     * @param firstNodeValue first node to evaluate.
     * @param secondNodeValue second node to evaluate.
     * @return the nearest ancestor from two nodes.
     * @throws java.lang.Exception
     */
    @RequestMapping(value = "/lowestCommonAncestor/{treeId}/{firstNodeValue}/{secondNodeValue}")
    public NodeResponse getLowestCommonAncestor(@PathVariable Long treeId, 
            @PathVariable Integer firstNodeValue, @PathVariable Integer secondNodeValue) throws Exception {

        return nodeService.getLowestCommonAncestor(treeId, firstNodeValue, secondNodeValue);
    }    
}