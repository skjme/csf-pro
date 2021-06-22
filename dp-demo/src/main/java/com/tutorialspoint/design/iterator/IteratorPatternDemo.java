package com.tutorialspoint.design.iterator;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for(Iterator iter = nameRepository.getIterator(); iter.hasNext(); ){
            String next = (String)iter.next();
            System.out.println(" Name: " + next);
        }
    }
}
