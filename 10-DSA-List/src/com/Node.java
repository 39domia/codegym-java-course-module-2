package com;

public class Node {
    public Node next;
    private Object data;

    public Node(Object data){
        this.data = data;
    }
    public Object getData(){
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
