package e3;

public class RandomMul implements MfaStrategy{

    @Override
    public String generateCode() {
        String num1, num2, num3, num4;
        num1=Integer.toString((int) (Math.random()*10)); num2=Integer.toString((int) (Math.random()*10));
        num3=Integer.toString((int) (Math.random()*10)); num4=Integer.toString((int) (Math.random()*10));
        return (num1+num2+"-"+num3+num4);
    }

}
