package com.example


import spock.lang.Specification
/**
 * Created by yongyeonkim on 2016. 8. 7..
 */
class PlyonUserDetailsServiceSpec extends Specification{

    def "정상적인 사용자 정보를 로딩할 때 반환된 객체 타입과 정보 확인"() {
        setup:
        def user = new LoginVO()

        def mockUserRepo = Mock(LoginVO.class)
        def login = new LoginVO()


        when:
        def userDetail = login.isMember();


        then:
        user.isMember() == userDetail
    }
}
