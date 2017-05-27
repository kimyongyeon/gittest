package com.example;

/**
 * Created by yongyeonkim on 2016. 7. 22..
 */
public class MailCommonService {

    void send(Object helloController) {
        HelloController helloController1 = (HelloController)helloController;
        ((HelloController) helloController).getList();

        HelloDAO helloDAO = (HelloDAO)helloController;
    }

    void msg1() {
        System.out.println("나는 이메일을 1 보낸다.");
    }


    void msg2() {
        System.out.println("나는 이메일을 2 보낸다.");
    }


}
