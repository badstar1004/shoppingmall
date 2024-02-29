package org.example.shoppingmall.mapper;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.example.shoppingmall.domain.consumer.domain.Consumer;
import org.example.shoppingmall.domain.consumer.model.form.ConsumerRegisterForm;
import org.example.shoppingmall.domain.consumer.model.sessiondto.SessionDto;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ConsumerMapper {
    /*
    * 로그인 시 이메일 조회
    * */
    Optional<Consumer> findByEmail(String email);

    /*
    * 이메일 중복 확인
    * */
    int checkEmail(String email);

    /*
    * 회원가입 등록
    * */
    int membershipRegister(ConsumerRegisterForm consumerRegisterForm);

    /*
    * 찜 목록 개수, 장바구니 개수 조회
    * */
    SessionDto countByWishAndBasket(Long consumerId);

    int existsById(Long consumerId);
}
