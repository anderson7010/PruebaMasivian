package com.masivian.test.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This clase defines the objects of node type.
 *
 * @author Anderson Vega
 */
@Entity
public class Node implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "tree_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Tree tree;
    private Integer nodeValue;
    private Integer leftNodeValue;
    private Integer rightNodeValue;
    private Integer nodeLevel;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public Integer getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(Integer nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Integer getLeftNodeValue() {
        return leftNodeValue;
    }

    public void setLeftNodeValue(Integer leftNodeValue) {
        this.leftNodeValue = leftNodeValue;
    }

    public Integer getRightNodeValue() {
        return rightNodeValue;
    }

    public void setRightNodeValue(Integer rightNodeValue) {
        this.rightNodeValue = rightNodeValue;
    }

    public Integer getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }
}
