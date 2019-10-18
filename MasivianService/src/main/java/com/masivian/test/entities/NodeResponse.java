package com.masivian.test.entities;

import java.io.Serializable;

/**
 * This clase defines the objects of node type.
 *
 * @author Anderson Vega
 */
public class NodeResponse implements Serializable {

    private Integer nodeValue;
  
    public Integer getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(Integer nodeValue) {
        this.nodeValue = nodeValue;
    }
}
