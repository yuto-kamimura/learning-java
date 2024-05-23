package test;

import java.util.ArrayList;
import java.util.List;

public class reversePoland {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Double val1, val2;
        for (String arg : args) {
            /*
             * 演算子の場合は、スタックから前二つの値を取り出し、計算結果をスタックに保存
             * 数値の場合は、String型をDouble型に直してスタックに保存
             */

            switch (arg) {
                case "+":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    stack.push(val2 + val1); 
                    break;
                case "-":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    stack.push(val2 - val1);
                    break;
                case "*":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    stack.push(val2 * val1);
                    break;
                case "/":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    stack.push(val2 / val1);
                    break;
                default:
                    stack.push(Double.parseDouble(arg));
                    break;
            }
        }

        System.out.println(stack.pop());
    }

}

class Stack {
    List<Double> list = new ArrayList<Double>();

    void push(Double num) {
        list.add(list.size(), num); // スタック(リスト)の一番後ろに数値を追加する。
    }

    Double pop() {
        Double val = list.get(list.size() - 1); // スタックの一番最後の数値を取り出す
        list.remove(list.size()-1); // 取り出した箇所のリスト要素は削除する
        return val; // 取り出した値を返す
    }

}