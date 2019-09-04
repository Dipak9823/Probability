package com.thoughtworks.bootcamp.probability;

public class Probability {

    private final float value;
    Probability(float count){
        this.value =count;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;

       Probability that=(Probability) obj;
        return this.value==that.value;
    }
    @Override
    public int hashCode() {
        return  (int) value;
    }

    public Probability notOccurrence() {
        return new Probability(1.0f-value);
    }

    public Probability and(Probability event) {
        return new Probability(value * event.value);
    }

    public Probability or(Probability event) {
        return new Probability(value).notOccurrence().and(new Probability(event.value).notOccurrence()).notOccurrence();
    }
}
