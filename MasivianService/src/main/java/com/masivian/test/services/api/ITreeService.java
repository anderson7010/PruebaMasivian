package com.masivian.test.services.api;

import com.masivian.test.entities.Tree;
import org.springframework.http.ResponseEntity;

/**
 * Trees service interface.
 * @author Anderson Vega
 */
public interface ITreeService {

    /**
     * Method to create a binary tree.
     *
     * @param tree object with information to create the tree.
     * @return final state of the request.
     */
    public ResponseEntity createTree(Tree tree);
}
