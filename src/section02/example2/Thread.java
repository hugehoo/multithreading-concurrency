package section02.example2;

public class Thread {
    // Thread Class 를 직접 생성하는 대신 상속을 활용
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        newThread.setName("newThread");
        newThread.start();
    }
    public static class NewThread extends java.lang.Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + this.getName());
        }
    }
}
