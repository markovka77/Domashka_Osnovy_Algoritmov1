package com.example.domashka_osnovy_algoritmov1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringListLogic implements StringList    {
    private int size = 10;
    private final String[] stringList = new String[size];


    @Override
    public String add(String item) {
        sizeValidate();
        validate(item);
        stringList[size++]=item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validate(item);
        valideteIndex(index);
        sizeValidate();
        if(index==size) {
            stringList[size++] = item;
            return item;
        }
        System.arraycopy(stringList,index,stringList,index-1,size-index);
       stringList[index]=item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        valideteIndex(index);
        validate(item);
        stringList[index]=item;
        return item;
    }

    @Override
    public String remove(String item) {
        validate(item);
        int index = indexOf(item);
        if(index == -1){
            throw new ElementNotFoundException();
        }
        if(index==size){
            stringList[size--]=null;
            return item;
        }

        System.arraycopy(stringList,index+1,stringList,index,size-index);

        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        valideteIndex(index);
        if (index==-1){
            throw new ElementNotFoundException();
        }
        String item = stringList[index];
        if(index==size){
            stringList[size--]=null;
            return item;
        }

        System.arraycopy(stringList,index+1,stringList,index,size-index);

        size--;



        return item;
    }

    @Override
    public boolean contains(String item) {
       return indexOf(item)!= -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)){
                return i;
            }
        }
      return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringList.length - 1; i >= 0; i--) {
            if(stringList[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        valideteIndex(index);
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
       return Arrays.equals(stringList,otherList.toArray());

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
       return size == 0;

    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public String[] toArray() {
       return Arrays.copyOf(stringList,size);

    }


    private void validate(String item){
        if(item==null){
            throw new NullItemException();
        }
    }
    private void sizeValidate(){
        if(size==stringList.length){
            throw new StorageIsFullException();
        }
    }
    private void valideteIndex(int index){
        if(index<0||index>size){
            throw new InvalidIndexExseption();
        }
    }
}

