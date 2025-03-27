package org.example;

import java.text.DecimalFormat;

public class Main {
    void go(int a){
        ;
    }
    public static void main(String[] args) {
        // 1 -Создать одномерный массив z типа short. Заполнить его нечётными числами от 3 до 25 включительно в порядке возрастания.
        short[] z1 = new short[12];
        int flag = 0;
        for(short i = 3; i <= 25; i++){
            if(i % 2 == 1){
                z1[flag] = i;
                flag++;
            }
        }

        //2 - Создать одномерный массив x типа float. Заполнить его 19-ю случайными числами в диапазоне от [-10.0, 7.0)
        float[] x = new float[19];
        for(int i = 0; i < x.length; i++){
            x[i] = (float) (-10.0 + Math.random() * (7.0 + 10.0));
        }

       //3
        double z2[][] = new double[12][19];

        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 19; j++){
                switch (z1[i]){
                    case (9):
                        z2[i][j] = Math.pow( Math.E, Math.sin(Math.pow(x[j] / (x[j] - 1), 2)));
                        break;
                    case 5,  11,  13, 19 ,23 , 25:
                        z2[i][j] = Math.pow(3/ (1 - Math.atan(1/ Math.pow(Math.E, Math.abs(x[j])))), 2);
                        break;
                    default:
                        double step1 = ((double) 1 /4) /  (Math.atan(Math.cos(Math.tan(Math.pow(Math.PI, x[j])))) - 1);
                        z2[i][j] = Math.pow(Math.sin(Math.pow(Math.atan(x[j]) , Math.asin((x[j] - 1.5)/ 17))), step1);
                        break;
                }
            }
        }

        for (int i = 0; i < 12;  i++){
            for (int j = 0; j < 19; j++){

                DecimalFormat df = new DecimalFormat("#.####");
                String formattedNumber = df.format(z2[i][j]);
                System.out.print(formattedNumber + "  ");
            }
            System.out.println();
        }




    }
    void go(){
        ;
    }
}