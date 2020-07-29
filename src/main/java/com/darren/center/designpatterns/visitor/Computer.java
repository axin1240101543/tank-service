package com.darren.center.designpatterns.visitor;

/**
 * <h3>tank-service</h3>
 * <p>访问者设计模式</p>
 *
 * @author : Darren
 * @date : 2020年07月29日 16:15:20
 **/
public class Computer {

    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor visitor){
        this.cpu.accept(visitor);
        this.memory.accept(visitor);
        this.board.accept(visitor);
    }

    public static void main(String[] args) {
        PersonelVisitor personelVisitor = new PersonelVisitor();
        new Computer().accept(personelVisitor);
        System.out.println(personelVisitor.totalPrice);
    }
}

abstract class ComputerPart{

    abstract void accept(Visitor visitor);

    abstract double getPrice();

}

class CPU extends ComputerPart{

    @Override
    void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart{

    @Override
    void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart{

    @Override
    void accept(Visitor visitor) {
        visitor.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

interface Visitor{

    void visitCpu(CPU cpu);

    void visitMemory(Memory memory);

    void visitBoard(Board board);

}


class PersonelVisitor implements Visitor{

    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.85;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.95;
    }
}