package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // 다른 클래스에서 못 쓰도록 설정
    private SingletonService() {

    }

    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }

}
