package com.example.shop.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * 주문 정보 저장 (생성)
     * @param order 저장할 Order 엔티티
     */
    public void save(Order order) {
        em.persist(order);
    }

    /**
     * 개별 주문 정보 상세 조회
     * @param id 주문의 고유 식별자
     * @return Order 엔티티 (없으면 null 반환)
     */
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    /**
     * 전체 주문 목록 조회
     * @return Order 엔티티 리스트
     */
    public List<Order> findAll() {
        // JPQL: Order 엔티티 전체 조회
        return em.createQuery("select o from Order o", Order.class)
                .getResultList();
    }

    // 추가: 특정 회원(memberId)의 주문 목록 조회 (유용할 수 있어 추가)
    public List<Order> findByMemberId(String memberId) {
        return em.createQuery(
                "select o from Order o where o.memberId = :memberId", Order.class
        ).setParameter("memberId", memberId).getResultList();
    }

    /**
     * 주문 정보 삭제
     * @param id 삭제할 주문의 고유 식별자
     */
    public void deleteById(Long id) {
        Order order = em.find(Order.class, id);
        // 엔티티가 존재할 경우에만 삭제 (null 체크가 필요하지만, Service에서 처리할 수도 있음)
        if (order != null) {
            em.remove(order);
        }
    }
}