package sample;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Map<String, Integer> scoreMap = new HashMap<>();
            if (scoreMap.isEmpty()) {
                throw new Exception();
            }

            System.out.println("test1");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
