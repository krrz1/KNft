package com.krrz.common.model;

public class Possession {
    private Collection collection;
    private int count ;

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Possession(Collection collection, int count) {
        this.collection = collection;
        this.count = count;
    }
}
