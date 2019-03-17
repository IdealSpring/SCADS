package cn.ccut.algorithm.offer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowsNum = Integer.valueOf(sc.nextLine());
        char[][] lines = new char[rowsNum][];

        for(int i = 0; i < rowsNum; i++){
            char[] chars = sc.nextLine().toCharArray();
            lines[i] = chars;
        }

        for (char[] line : lines)
            check(line);
    }

    private static void check(char[] line) {
        for (int i = 0; i < line.length; i++) {
            int next = i + 1;
            while (next < line.length && line[i] == line[next]) {
                next++;
            }

            if (next - i > 2) {
                for (int j = i + 2; j < line.length - 1; j++) {
                    if (next >= line.length) {
                        line[j] = '0';
                    } else {
                        line[j] = line[next++];
                    }

                }
            }
        }

        for (char ch : line) {
            if (ch != '0')
                System.out.print(ch);
        }
        System.out.println();
    }
}
