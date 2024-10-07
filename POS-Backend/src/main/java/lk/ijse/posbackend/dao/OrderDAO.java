package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity, String> {
}
