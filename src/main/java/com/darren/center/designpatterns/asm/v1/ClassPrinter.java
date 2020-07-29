package com.darren.center.designpatterns.asm.v1;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM4;

/**
 * <h3>tank-service</h3>
 * <p>通过ASM访问class文件的内容</p>
 *
 * @author : Darren
 * @date : 2020年07月29日 17:03:39
 **/
public class ClassPrinter extends ClassVisitor {

    public ClassPrinter() {
        super(ASM4);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + "extends" + superName + "{");
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println(" " + name);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println(" " + name);
        return null;
    }

    @Override
    public void visitEnd() {
        System.out.println("}");
    }


    public static void main(String[] args) throws IOException {
        ClassPrinter classPrinter = new ClassPrinter();
        ClassReader classReader = new ClassReader("java.lang.Runnable");
        //classReader接受classPrinter的访问
        classReader.accept(classPrinter, 0);


        ClassReader classReader1 = new ClassReader(ClassPrinter.class.getClassLoader()
                .getResourceAsStream("com/darren/center/designpatterns/asm/T1.class"));
        classReader1.accept(classPrinter, 0);
    }
}
