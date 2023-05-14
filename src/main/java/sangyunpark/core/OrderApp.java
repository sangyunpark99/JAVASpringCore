package sangyunpark.core;

import sangyunpark.core.member.Grade;
import sangyunpark.core.member.Member;
import sangyunpark.core.member.MemberService;
import sangyunpark.core.member.MemberServiceImpl;
import sangyunpark.core.order.Order;
import sangyunpark.core.order.OrderService;
import sangyunpark.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) { // Member, Order test

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
