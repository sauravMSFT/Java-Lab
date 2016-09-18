package com.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by saurav on 18/9/16.
 */
public class Matrix {
    protected int rows, columns;
    protected int[][] val;

    public void read() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] p;
        for (int i = 0; i < rows; ++i) {
            p = br.readLine().trim().split(" ");
            for (int j = 0; j < columns; ++j) {
                val[i][j] = Integer.parseInt(p[j]);
            }
        }
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        val = new int[rows][columns];
    }

    public Matrix multiply(Matrix B) {
        Matrix C = new Matrix(rows, B.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < B.columns; j++) {
                C.val[i][j] = 0;
                for (int k = 0; k < columns; k++) {
                    C.val[i][j] += val[i][k] * B.val[k][j];
                }
            }
        }
        return C;
    }

    @Override
    public String toString() {
        StringBuffer rep = new StringBuffer();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                rep.append(val[i][j] + " ");
            }
            rep.append('\n');
        }
        return rep.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        System.out.print("Enter number of rows in A: ");
        a = Integer.parseInt(br.readLine());
        System.out.print("Enter number of columns in A: ");
        b = Integer.parseInt(br.readLine());

        Matrix A = new Matrix(a, b);

        System.out.print("Enter number of rows in B: ");
        a = Integer.parseInt(br.readLine());
        System.out.print("Enter number of columns in B: ");
        b = Integer.parseInt(br.readLine());

        Matrix B = new Matrix(a, b);

        System.out.println("Enter matrix A:");
        A.read();
        System.out.println("Enter matrix B");
        B.read();

        Matrix C = A.multiply(B);
        System.out.println(C);
    }
}
