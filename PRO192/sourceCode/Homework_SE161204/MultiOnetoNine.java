
public class MultiOnetoNine {

    //methods
    void show() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= 10; j++) System.out.format("%d x %d = %d\n", i, j, i * j);
            System.out.println();
        }

    }
}
