package unitins.application;

import unitins.util.ArrayTins;

public class Main {

    public static void main(String[] args) {
        ArrayTins<Integer> array = new ArrayTins<>();

        for (Integer i = 9; i >= 0; i--) {
            array.add(i);
        }

        System.out.println("Array de Inteiros: \n" + array);
        array.sort();
        System.out.println("Array de Inteiros Ordenado Crescentemente: \n" + array);
    }

}
