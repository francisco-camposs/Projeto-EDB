package br.com.company.model;

import java.util.BitSet;

public class UsableBitSet extends BitSet {
    private int trueSize;

    public UsableBitSet() {
        this.trueSize = 0;
    }

    public UsableBitSet(UsableBitSet bit) {
        for (int i = 0; i < bit.trueSize; i++){
            this.set(i,bit.get(i));
        }
        this.trueSize = bit.trueSize;
    }

    @Override
    public void set(int bitIndex, boolean value) {
        super.set(bitIndex, value);
        trueSize += 1;
    }

    @Override
    public boolean get(int index) throws IndexOutOfBoundsException{
        if (index < 0 | index >= trueSize){
            throw new IndexOutOfBoundsException();
        }
        else{
            return super.get(index);
        }
    }

    @Override
    public void clear() {
        trueSize = 0;
        super.clear();
    }

    public int getTrueSize(){
        return trueSize;
    }

    public boolean equals(UsableBitSet obj){
        if (trueSize == obj.trueSize){
            for (int i = 0; i < trueSize;i++){
                if (get(i) != obj.get(i)){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
