import static java.lang.Math.*;
import java.text.DecimalFormat ;

public class One {
    public static void main(String[] args) {

        long[] SevenTo23 = new long[] {
                7, 9, 11, 13, 15, 17, 19, 21, 23};

        float[] Randoms = new float[13];
        for(int i = 0; i < 13; i++) {
            Randoms[i] = (float)(Math.random() * 17.0 - 10.0);
        }

        float[][] TurboMath = new float[9][13];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 13; j++) {
                float x = Randoms[j];
                long temp = SevenTo23[i];
                switch((int)temp) {
                    case 15:
                        TurboMath[i][j] = (float)(pow(((log(acos((x - 1.5) / 17.0)) - 2.0/3.0) / pow((cbrt(x) / (cbrt(x) - 0.25)), pow(x/2.0, x))), 3));
                        break;
                    case 7, 13, 19, 23 :
                        TurboMath[i][j] = (float)(pow((tan(log(abs(x))) / (1 - pow((3.0 / tan(x)), 2))), 3));
                        break;
                    default:
                        TurboMath[i][j] = (float)(pow((log(pow(((4.0 + abs(x)) / 3.0), x))), ((3.0/4.0) / pow((((3.0/4.0) / pow(x, x))), 2))));
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 13; j++) {
                if(Double.isNaN(TurboMath[i][j])) {
                    System.out.print("***       ");
                } else {
                    System.out.printf("%-10.2f", TurboMath[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
