package sangyunpark.core.singleton;

public class SingleTonService {

    private static final SingleTonService instance = new SingleTonService(); // 클래스 레벨로 올라가므로 1개만 존재한다.

    public static SingleTonService getInstance(){
        return instance;
    }

    private SingleTonService() { // 객체 생성 방지

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
