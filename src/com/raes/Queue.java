package com.raes;
import java.util.ArrayList;
import java.util.List;

class Queue {
    private Node current;

    public void add(Object element){
        Node create = new Node();
        create.element = element;
        if (current != null) {
            create.node = current;
        }
        current = create;
    }

    public void show(){
        Node temporal = current;
        while (temporal.node != null){
            System.out.println(temporal.element);
            temporal = temporal.node;
        }
        System.out.println(temporal.element);
    }

    public List<?> values(){
        List<Object> values = new ArrayList();
        Node temporal = current;
        while (temporal.node != null){
            values.add(temporal.element);
            temporal = temporal.node;
        }
        values.add(temporal.element);
        return values;
    }

    public void delete(){
        current = null;
    }
}
