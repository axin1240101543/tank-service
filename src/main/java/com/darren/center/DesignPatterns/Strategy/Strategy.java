package com.darren.center.DesignPatterns.Strategy;

import java.util.Arrays;

/**
 * <h3>tank-service</h3>
 * <p>策略模式</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 12:05:51
 **/
public class Strategy {

    /**
     * 1、对int类型进行排序？
     * 2、想对double类型排序？
     * 3、想对Cat排序？
     * 4、想对Dog排序？
     * 5、对Cat的比较的属性更加灵活？
     * 使用策略模式，让猫不仅可以按重量排序，还可以按高度排序
     * 6、使用lambda表达式
     *
     *
     * 策略模式封装的是做一件事儿不同的执行方式。
     * @param args
     */
    public static void main(String[] args) {
        //1
        int [] a = {9, 2, 3, 5, 7, 1, 4};
        Sorter1 sorter1 = new Sorter1();
        sorter1.sort(a);
        System.out.println(Arrays.toString(a));

        //3
        Cat[] cat = {new Cat(1,1), new Cat(5,5), new Cat(3,3)};
        Sorter2 sorter2 = new Sorter2();
        sorter2.sort(cat);
        System.out.println(Arrays.toString(cat));

        //4
        Dog[] dog = {new Dog(1), new Dog(5), new Dog(3)};
        Sorter3 sorter3 = new Sorter3();
        sorter3.sort(dog);
        System.out.println(Arrays.toString(dog));

        //5
        Sorter4<Dog> sorter41 = new Sorter4();
        sorter41.sort(dog, new DogComparator());
        System.out.println(Arrays.toString(dog));

        Sorter4<Cat> sorter42 = new Sorter4();
        sorter42.sort(cat, new CatHeightComparator());
        System.out.println(Arrays.toString(cat));
        sorter42.sort(cat, new CatWeightComparator());
        System.out.println(Arrays.toString(cat));

        //6
        Sorter4<Dog> sorter43 = new Sorter4();
        sorter43.sort(dog, (o1, o2)->{
            if (o1.food < o2.food) return 1;
            else if (o1.food > o2.food) return -1;
            else return 0;
        });
        System.out.println(Arrays.toString(dog));
    }

    /**
     * 冒泡排序
     */
    static class  Sorter1{
        public int[] sort(int[] array){
            if (array == null) return null;
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length - i; j++) {
                    if (array[j] > array[j+1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            return array;
        }
    }


    static class  Sorter2{
        public Cat[] sort(Cat[] array){
            if (array == null) return null;
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length - i; j++) {
                    if (array[j].compareTo(array[j+1]) > 0){
                        Cat temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            return array;
        }
    }

    static class  Sorter3{
        public Comparable[] sort(Comparable[] array){
            if (array == null) return null;
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length - i; j++) {
                    if (array[j].compareTo(array[j+1]) > 0){
                        Comparable temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            return array;
        }
    }

    static class  Sorter4<T>{
        public void sort(T[] array, Comparator<T> comparator){
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length - i; j++) {
                    if (comparator.compare(array[j], array[j+1]) > 0){
                        T temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }
    }

}
