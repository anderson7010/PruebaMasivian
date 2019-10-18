package com.masivian.test.services.impl;

import com.masivian.test.entities.Node;
import com.masivian.test.entities.NodeResponse;
import com.masivian.test.entities.Tree;
import com.masivian.test.repositories.NodeRepository;
import com.masivian.test.repositories.TreeRepository;
import com.masivian.test.services.api.INodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Nodes service.
 * @author Anderson Vega
 */
@Service
public class NodeService implements INodeService {
    
    private final String NODES_EXISTS = "The nodes must be exists.";
    private final String TREE_DOES_NOT_EXISTS = "Tree doesn't exists.";
    
    @Autowired
    NodeRepository nodeRepository;

    @Autowired
    TreeRepository treeRepository; 
    
    @Override
    public NodeResponse getLowestCommonAncestor(@PathVariable Long treeId, 
            @PathVariable Integer firstNodeValue, @PathVariable Integer secondNodeValue) throws Exception {

        if (!treeRepository.existsById(treeId)) {
            throw new Exception(TREE_DOES_NOT_EXISTS);
        }
        
        Tree tree = new Tree();
        tree.setId(treeId);
        
        NodeResponse nodeResponde = new NodeResponse();
        
        Node firstNode = nodeRepository.findByNodeValue(tree, firstNodeValue);
        Node secondNode = nodeRepository.findByNodeValue(tree, secondNodeValue);
        
        if (firstNode == null || secondNode == null) {
            throw new Exception(NODES_EXISTS);
        } else if (firstNode == secondNode) {
            Node ancestorNode = nodeRepository.findByDecendantNode(tree, firstNode.getNodeValue());
            if (ancestorNode == null) {
                nodeResponde.setNodeValue(firstNode.getNodeValue());
            } else {
                nodeResponde.setNodeValue(ancestorNode.getNodeValue());
            }            
        }
        
        nodeResponde.setNodeValue(nodesAreEquals(tree, firstNode, secondNode));
        
        return nodeResponde;
    }
    
    private Integer nodesAreEquals(Tree tree, Node firstNode, Node secondNode){
        
        Node firstAncestorNode = nodeRepository.findByDecendantNode(tree, firstNode.getNodeValue());
        Node secondAncestorNode = nodeRepository.findByDecendantNode(tree, secondNode.getNodeValue());
        
        if (firstAncestorNode == null || firstNode == secondNode) {
            return firstNode.getNodeValue();
        } else if (secondAncestorNode == null) {
            return secondNode.getNodeValue();
        }
        
        if (firstAncestorNode == secondAncestorNode) {
            return firstAncestorNode.getNodeValue();
        }
        
        Integer firstNodeLevel = firstAncestorNode.getNodeLevel();
        Integer secondNodeLevel = secondAncestorNode.getNodeLevel();
        
        if (firstNodeLevel.equals(secondNodeLevel)) {
            return nodesAreEquals(tree, firstAncestorNode, secondAncestorNode);
        } else if (firstNodeLevel > secondNodeLevel) {
            return nodesAreEquals(tree, firstAncestorNode, secondNode);
        } else {
            return nodesAreEquals(tree, firstNode, secondAncestorNode);
        }
    }
}
