package com.example.santos.beizerline;

public class Calculator {

    public static int getTargetCoordinate(float progress, int points[]) {
        int num = points.length;

        for (int i = num - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                points[j] =
                        points[j] + (int) ((points[j + 1] - points[j]) * progress);
            }
        }
        return points[0];
    }

}