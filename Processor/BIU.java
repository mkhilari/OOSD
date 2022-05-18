package Processor;

public class BIU {
    
    public static final int REGISTER_SIZE = 4;
    public static final int QUEUE_SIZE = 6;

    private int[] registers = new int[REGISTER_SIZE];

    public BIU() {

    }

    public Integer getPhysicalAddress(int index, Integer offset) {

        return 0;
    }

    public byte[] getData(Integer physicalAddress) {

        byte[] queue = new byte[QUEUE_SIZE];

        return queue;
    }

    public void sendData(Bus bus) {
        
    }
}
