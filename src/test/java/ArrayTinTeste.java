import org.junit.Assert;
import org.junit.Test;
import unitins.util.ArrayTins;

import java.util.Optional;

public class ArrayTinTeste {

    @Test
    public void addArraySucess() {
        ArrayTins<Integer> array = new ArrayTins<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        Assert.assertFalse(array.isEmpty());
        Assert.assertEquals(4, array.size());
    }

    @Test
    public void addInPositionSucess() {
        ArrayTins<Integer> array = new ArrayTins<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        array.add(1, 5);

        Assert.assertFalse(array.isEmpty());
        Assert.assertEquals(Optional.of(5).get(), array.get(1));
    }

    @Test
    public void addInPositionError() {
        ArrayTins<Integer> array = new ArrayTins<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.add(5, 5);
        });
    }

    @Test
    public void removeSucess() {
        ArrayTins<Integer> array = new ArrayTins<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        Integer numberRemoved = array.remove(0);

        Assert.assertEquals(Optional.of(2).get(), array.get(0));
        Assert.assertEquals(Optional.of(1).get(), numberRemoved);
    }

    @Test
    public void removeError() {
        ArrayTins<Integer> array = new ArrayTins<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        array.remove(0);

        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.remove(3);
        });
    }

    @Test
    public void sortArraySucess() {
        ArrayTins<Integer> array = new ArrayTins<>();

        for (Integer i = 9; i >= 1; i--) {
            array.add(i);
        }

        ArrayTins<Integer> orderedArray = new ArrayTins<>();
        orderedArray.add(1);
        orderedArray.add(2);
        orderedArray.add(3);
        orderedArray.add(4);
        orderedArray.add(5);
        orderedArray.add(6);
        orderedArray.add(7);
        orderedArray.add(8);
        orderedArray.add(9);

        array.sort();

        Assert.assertFalse(array.isEmpty());
        Assert.assertEquals(orderedArray, array);
    }

}
