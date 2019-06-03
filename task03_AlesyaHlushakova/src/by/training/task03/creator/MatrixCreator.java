package by.training.task03.creator;

import by.training.task03.entity.Matrix;
import by.training.task03.exception.MatrixException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MatrixCreator {
    public void fillRandomized(Matrix t, int start, int end) {
        int v = t.getVerticalSize();
        int h = t.getHorizontalSize();
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < h; j++) {
                try {
                    int value = (int)(Math.random() * (end - start) + start);
                    t.setElement(i, j, value);
                } catch (MatrixException e) {
                    /* в данном случае exception невозможен, поэтому обработка отсутствует */
                }
            }
        }
    }
 public void fillFromFile(Matrix t, String f) {
     int v = t.getVerticalSize();
     int h = t.getHorizontalSize();
     File file = new File(f);
     Scanner scanner = null;
     try {
         scanner = new Scanner(file);
         for (int row=0; row<h; row++){
             for (int col=0; col<v; col++){
                 int number = scanner.nextInt();
                 if (row == col && number != 0) {
                     throw new MatrixException("Zero should be on diagonal. ");
                 }
                 t.setElement(row, col, number);
             }
             }

         }
     catch (FileNotFoundException ex) {
         System.err.println("Error reading from file");
     }
     catch (MatrixException e) {
         System.err.println("Error reading from file");
     }
 }

}
