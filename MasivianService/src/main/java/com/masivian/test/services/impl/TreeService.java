package com.masivian.test.services.impl;

import com.masivian.test.entities.Tree;
import com.masivian.test.repositories.TreeRepository;
import com.masivian.test.services.api.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Trees service.
 * @author Anderson Vega
 */
@Service
public class TreeService implements ITreeService {
    
    private final String INVALID_PARAMS = "Invalid parameters.";
    private final String REQUIRED_NODES = "The nodes are required.";
    
    @Autowired
    TreeRepository treeRepository; 
    
    @Override
    public ResponseEntity createTree(@RequestBody Tree tree) {
        
        if (tree == null) {
            return ResponseEntity.badRequest().body(INVALID_PARAMS);
        }
        if (tree.getNodes() == null) {
            return ResponseEntity.badRequest().body(REQUIRED_NODES);
        }
        
        treeRepository.save(tree);
        return ResponseEntity.ok().build();
    }
}
