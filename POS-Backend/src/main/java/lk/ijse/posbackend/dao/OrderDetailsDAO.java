package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetailsEntity, String> {
}
