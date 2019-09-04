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

    public Probability notOccurring() {
        return new Probability(1.0f-value);
    }

    public Probability occurringTogether(Probability event) {
        return new Probability(value * event.value);
    }

    public Object or(Probability pointFiveProbability2) {
        return new Probability(0.0f);
    }
}
