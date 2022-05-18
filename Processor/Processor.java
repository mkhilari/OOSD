package Processor;

public class Processor {
    
    private Bus bus;
    private BIU biu;
    private EU eu;

    public Processor(Bus bus, BIU biu, EU eu) {

        this.bus = bus;
        this.biu = biu;
        this.eu = eu;
    }
}
