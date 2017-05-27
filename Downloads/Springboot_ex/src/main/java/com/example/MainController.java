package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yongyeonkim on 2016. 5. 28..
 */
@RestController
public class MainController {

    @Autowired
    MemberService memberService;

    @Autowired
    BoardService boardService;

    @PersistenceContext
    private EntityManager em;

    public void test() {

    }

    public void entitySave(){
        String id = "kim";
        String name = "kimyongyeon";
        String address = "순천시";
        // Entity 객체를 만드는 것은 일반 Java 객체를 생성하듯이 new 생성자를 사용하면 되며 이를
        // DB에 저장하려면 다음과 같이 Entitymanager.persist() 메소드를 호출해야 한다
        Customer customer = new Customer(id, name, address);
        em.persist(customer);

        // DB에서 하나의 Entity객체를 가져오려면
        Customer e = em.find(Customer.class, id);

        Query query = em.createQuery("select c from Customer c");
        List list = query.getResultList(); // Java Persistence Query Language를 이용하여 모든 Entity들을 가져오거나 특정 필드 값을 비교하여 Entity를 가져올 수 있다
        e.setName("kimyy"); // 수정
        em.flush();

        // static query
        // Entity class에 선언해 두고 필요할때 마다 불러 쓰는 Query
        // @NamedQuery @NamedNativeQuery
        Query query1 = em.createNamedQuery("findCustomerByName");
        query1.setParameter("name", name);
        List list1 = query1.getResultList();

        // Java SE에서 JPA 사용하기
        // Java SE 환경에서 사용할 때는 Application-managed EntityManager 만 사용할 수 있다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderunit");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        tx.commit();
        em.close();
        emf.close();
    }

    @RequestMapping(value = "/rest")
    public List<Member> index(){

        Member m = new Member();
        m.setName("kimyongyeon");
        m.setPhone("010-1234-1234");
        memberService.save(m);
        return memberService.findAll();

    }

    @RequestMapping(value = "/rest/update")
    public String memberUpdate() {
        Member m = new Member();
        m.setPhone("010-123-1234");
        return "1";
    }

    @RequestMapping(value = "/list")
    public List<Board> boardList() {
        return boardService.findAll();
    }


    @RequestMapping(value = "/404")
    public String ExceptionTest() {
        return "404";
    }
}
