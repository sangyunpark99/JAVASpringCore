package sangyunpark.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 = " + url);
    }

    public void setUrl(String url) {

        System.out.println("setUrl");
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("Connect : " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() { // 의존관계 주입이 다끝나고 호출해준다.
        System.out.println("init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("destory");
        disconnect();
    }
}
