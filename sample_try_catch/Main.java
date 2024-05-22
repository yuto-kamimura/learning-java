package sample_try_catch;

public class Main {
    public static void main(String[] args) {
        InputData ipData = new InputData();
        String[] a = new String[] { "0.9", "0.8" };

        try {
            ipData.setInputData(a);
            Calculator calc = new Calculator();
            double sum = calc.add(ipData.getInputData());
            System.out.println("合計値は" + sum + "です。");
        } catch (NumberFormatException ex) {
            System.out.println("数値を入力してください。");
        } catch (RangeException e) {
            System.out.println(e);           
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("処理を終了します。");
        }
    }
}

class InputData {
    double[] inputData;

    void setInputData(String[] inputs) throws NumberFormatException {
        this.inputData = new double[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            double num = Double.parseDouble(inputs[i]);
            inputData[i] = num;
        }
    }

    double[] getInputData() {
        return this.inputData;
    }
}

class Calculator {
    double add(double[] nums) throws RangeException {
        double sum = 0.0;
        for (double num : nums) {
            if (num < 0 || num > 1) {
                throw new RangeException("数値" + num + "は取り扱い出来ない数値です。");
            }
            sum += num;
        }
        return sum;
    }
}

class RangeException extends Exception {
    RangeException(String msg) {
        super(msg);
    }
}