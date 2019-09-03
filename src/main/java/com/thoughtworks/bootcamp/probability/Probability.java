package com.thoughtworks.bootcamp.probability;

public class Probability {

    private float count;
    Probability(float count){
        this.count=count;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;

        Probability p=(Probability) obj;
        return count==p.count;
    }
    @Override
    public int hashCode() {
        return (int) count;
    }

}
