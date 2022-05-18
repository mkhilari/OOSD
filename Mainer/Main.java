package Mainer;

public class Main {
    
    public static void main(String[] args) {

        C aC = new C();
        
        aC.p();
    }
}

class A {

    public void p() {

        System.out.print(1);
    }
}

class B extends A {

    public void p() {

        System.out.print(2);
        super.p();
    }
}

class C extends B {

    public void p() {

        System.out.print(3);
        super.p();
    }
}

