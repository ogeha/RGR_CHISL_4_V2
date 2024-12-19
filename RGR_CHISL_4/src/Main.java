import java.util.Arrays;
import java.util.Scanner;
import java.math.*;

import static java.lang.Math.sqrt;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double[][] xy = new double[2][1];
        double[][] xyn = new double[2][1];
        xy[0][0] = x0;
        xy[1][0] = y0;
        double prov = 100000;
        while (prov > 0.0001){
            double[][] a = new double[2][1];
            double[][] b = new double[2][2];
            a[0][0] = xy[0][0] * xy[0][0] * xy[0][0] - xy[1][0] * xy[1][0] - 1;
            a[1][0] = xy[0][0] * (xy[1][0] * xy[1][0] * xy[1][0]) - xy[1][0] - 4;
            b[0][0] = 3 * (xy[0][0] * xy[0][0]); //производная по x первого уравнения
            b[1][0] = xy[1][0] * xy[1][0] * xy[1][0]; //производная по x второго уравнения
            b[0][1] = -2 * (xy[1][0]); //производная по y первого уравнения
            b[1][1] = 3 * xy[0][0] * (xy[1][0] * xy[1][0]) - 1;//производная по y второго уравнения
            double opred = b[0][0]*b[1][1]-b[1][0]*b[0][1];
            double[][] temp_b = new double[2][2];
            temp_b[0][0] = b[1][1] * (1/opred);
            temp_b[1][1] = b[0][0] * (1/opred);
            temp_b[0][1] = -b[1][0] * (1/opred);
            temp_b[1][0] = -b[0][1] * (1/opred);
            double jacob = temp_b[0][0]*temp_b[1][1] - temp_b[1][0]*temp_b[0][1];
            double[][] c = new double[2][2];
            c[0][0] = a[0][0];
            c[1][1] = b[1][1];
            c[1][0] = a[1][0];
            c[0][1] = b[0][1];
            double opred1 = c[0][0] * c[1][1] - c[1][0]*c[0][1];
            double[][] d = new double[2][2];
            d[0][0] = b[0][0];
            d[1][1] = a[1][0];
            d[1][0] = b[1][0];
            d[0][1] = a[0][0];
            double opred2 = d[0][0] * d[1][1] - d[1][0]*d[0][1];
            xyn[0][0] = xy[0][0] - jacob * opred1;
            xyn[1][0] = xy[1][0] - jacob * opred2;
            prov = sqrt(((xyn[0][0]-xy[0][0])*(xyn[0][0]-xy[0][0])) + ((xyn[1][0]-xy[1][0])*(xyn[1][0]-xy[1][0])));
            xy[0][0] = xyn[0][0];
            xy[1][0] = xyn[1][0];
        }
        System.out.println("Найденный x =" + " " + xyn[0][0]);
        System.out.println("Найденный y =" + " " + xyn[1][0]);
        System.out.println("Итерационная разница значений: " + " " + prov);
    }

}