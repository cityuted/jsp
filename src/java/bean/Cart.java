/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;

/**
 *
 * @author ted
 */
public class Cart {
    private ArrayList<Toy> toys = new ArrayList<Toy>();

    public Cart() {

    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }
    
    public void removeToy(Toy toy) {
        toys.remove(toy);
    }
    
    public ArrayList<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }
    
    public int getTotal() {
        int total = 0;
        for(int i=0;i<toys.size();i++){
            total += toys.get(i).getCashpoint()*toys.get(i).getQTY();
        }
        return total;
    }
    
    public int getSize(){
        return toys.size();
    }
    
    
}
