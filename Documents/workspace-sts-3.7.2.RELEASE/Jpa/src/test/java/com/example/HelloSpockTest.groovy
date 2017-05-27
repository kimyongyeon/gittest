package com.example

import spock.lang.Specification

/**
 * Created by yongyeonkim on 2016. 8. 7..
 */
class HelloSpockTest extends Specification
{
    def "로그인 테스트 "() {
        given: // 객체초기화 객체생성 설정
        def helloSpock = new HelloSpock()
        when: // 객체를 이용해서 값을 넣는부분
        def expected = helloSpock.sayHello("world2")
        then: // 비교
        expected == "hello world"
    }

}
