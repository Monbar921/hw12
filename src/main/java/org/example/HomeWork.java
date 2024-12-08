package org.example;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/problemset/problem/1324/C
     */
    @SneakyThrows
    public void frogSteps(InputStream in, OutputStream out) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))){
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; ++i) {
                String data = bufferedReader.readLine();
                int minCell = getMinCells(data);
                out.write(String.valueOf(minCell).getBytes());
                out.write(("\r\n").getBytes());
            }
        }
    }

    private int getMinCells(String data) {
        int dataLength = data.length();
        int prevCell = -1;
        int cells = -1;
        for (int i = 0; i < dataLength; ++i) {
            if (data.charAt(i) == 'R') {
                cells = Math.max(cells, i - prevCell);
                prevCell = i;
            }
        }
        return Math.max(cells, dataLength - prevCell);
    }

}
