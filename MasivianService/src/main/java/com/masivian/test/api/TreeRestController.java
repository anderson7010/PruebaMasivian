package com.masivian.test.api;

import com.masivian.test.entities.Tree;
import com.masivian.test.services.impl.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class defines the REST services to manage trees.
 * @author Anderson Vega
 */
@RestController
@RequestMapping("/tree")
public class TreeRestController {
    
    @Autowired
    TreeService treeService; 
    
    /**
     * Method to create a binary tree.
     *
     * @param tree object with information to create the tree.
     * @return final state of the request.
     */
    @PostMapping
    public ResponseEntity createTree(@RequestBody Tree tree) {
        
        return treeService.createTree(tree);
    }
}
