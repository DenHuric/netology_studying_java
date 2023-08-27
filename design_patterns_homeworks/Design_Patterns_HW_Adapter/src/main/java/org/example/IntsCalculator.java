package org.example;

public class IntsCalculator implements Ints {

    protected final Calculator target;

    public IntsCalculator() {
        this.target = new Calculator();
    }

    @Override
    public int sum(int arg0, int arg1) {
        Calculator.Formula calc = target.newFormula();
        calc.a = (double) arg0;
        calc.b = (double) arg1;
        calc.calculate(Calculator.Operation.SUM);
        Double d = new Double(calc.result());
        return d.intValue();


    }

    @Override
    public int mult(int arg0, int arg1) {
        Calculator.Formula calc = target.newFormula();
        calc.a = (double) arg0;
        calc.b = (double) arg1;
        calc.calculate(Calculator.Operation.MULT);
        Double d = new Double(calc.result());
        return d.intValue();
    }

    @Override
    public int pow(int a, int b) {
        Calculator.Formula calc = target.newFormula();
        calc.a = (double) a;
        calc.b = (double) b;
        calc.calculate(Calculator.Operation.POW);
        Double d = new Double(calc.result());
        return d.intValue();
    }
}
