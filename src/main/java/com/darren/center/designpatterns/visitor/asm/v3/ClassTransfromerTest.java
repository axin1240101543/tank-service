package com.darren.center.designpatterns.visitor.asm.v3;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * <h3>tank-service</h3>
 * <p>通过ASM改变Class文件内容</p>
 *
 * 实现动态代理
 *
 * @author : Darren
 * @date : 2020年07月29日 19:13:17
 **/
public class ClassTransfromerTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //读取Tank.class文件
        ClassReader classReader = new ClassReader(ClassTransfromerTest.class.getClassLoader()
                .getResourceAsStream("com/darren/center/designpatterns/visitor/asm/v3/Tank.class"));

        ClassWriter classWriter = new ClassWriter(0);
        ClassVisitor classVisitor = new ClassVisitor(ASM4, classWriter) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, methodVisitor) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/darren/center/designpatterns/visitor/asm/v3/TankTimeProxy",
                                "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        //将classReader读到的内容直接copy一份到classWriter中，然后写入文件
        //classReader.accept(classWriter, 0);

        //将classReader读到的内容通过classVisitor的修改，然后写入文件
        classReader.accept(classVisitor, 0);

        byte[] b = classWriter.toByteArray();

        //加载class，并创建实例
        MyClassLoader myClassLoader = new MyClassLoader();
        myClassLoader.loadClass("com.darren.center.designpatterns.visitor.asm.v3.TankTimeProxy");
        Class aClass = myClassLoader.defineClass("com.darren.center.designpatterns.visitor.asm.v3.Tank", b);
        aClass.getConstructor().newInstance();

        //创建文件夹
        String path = (String)System.getProperties().get("user.dir");
        File file = new File(path + "/com/darren/center/designpatterns/visitor/asm/v2/");
        file.mkdirs();

        //写入文件
        FileOutputStream fileOutputStream = new FileOutputStream(
                new File(path + "/com/darren/center/designpatterns/visitor/asm/v2/Tank_0.class"));
        fileOutputStream.write(b);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
