package advanced;

class SingletonPattern {
    private static volatile SingletonPattern instance; // volatile Only allows the singleton to be used when it is fully instantiated
    public String str;

    private SingletonPattern() {
    }

    static SingletonPattern getSingleInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) { // locks for multi-thread operations
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }

}

class Solution {
    public static void main(String[] args) {
        SingletonPattern inst1 = SingletonPattern.getSingleInstance();
        inst1.str = "hello world";

        System.out.println("Hello I am a singleton! Let me say " + SingletonPattern.getSingleInstance().str + " to you\n");
    }
}