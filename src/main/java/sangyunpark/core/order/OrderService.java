package sangyunpark.core.order;

import sangyunpark.core.member.Grade;
import sangyunpark.core.member.Member;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
    Member searchMember(Long id); // 멤버 조회
    void adjustDiscount(Grade grade); // 할인 정책
}
