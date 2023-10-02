import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        final int MAX_SIZE = 10;
        int[] randomArray = new int[MAX_SIZE];

        for (int i = 0;i<MAX_SIZE;i++){
            randomArray[i] = (int) (Math.random()*MAX_SIZE-1);
        }
        System.out.println("ARRAY SIN ORDENAR");
        System.out.println(Arrays.toString(randomArray));
        // ORDENARLOS
        for (int i=1;i<MAX_SIZE-1;i++){
            for (int j=0;j<MAX_SIZE-i;j++){
                if (randomArray[j]>randomArray[j+1]){
                    int temp = randomArray[j];
                    randomArray[j]=randomArray[j+1];
                    randomArray[j+1]=temp;
                }
            }
        }
        System.out.println("ARRAY ORDENADO");
        System.out.println(Arrays.toString(randomArray));

    }
}
