package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final 붙은거 가지고 생성자 만듬
public class OrderServiceImpl implements OrderService{

    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 기존 FIX -> RATE
    // 할인 정책 변경 시 코드를 고쳐야 함
    // OCP(개방 폐쇄 원칙) 위반 : 코드를 변경하지 않고 기능 추가 해야함

    // 인터페이스 뿐만 아닌, 구현체 클래스도 같이 의존하고 있음.
    // DIP(의존 역전 원칙) 위반 : 구현체가 아닌 추상화에 의존

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 이렇게만 하면 nullpointer exception 터짐
    // 이거 해결하려면 누군가가 적절한 구현체를 만들어줘야함

    @Autowired // 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository,
                            DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
