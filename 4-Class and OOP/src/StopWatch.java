public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public void start(){
        this.startTime =  System.currentTimeMillis();

    }
    public void stop(){
        this.endTime =  System.currentTimeMillis();

    }
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }

    public static void randomArray() {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(10000*Math.random());
        }
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        System.out.println("Start time " + sw.getStartTime());
        System.out.println("End time " + sw.getEndTime());
        sw.start();
        randomArray();
        sw.stop();
        System.out.println("Distance time in milli second: " + sw.getElapsedTime());
    }


}
