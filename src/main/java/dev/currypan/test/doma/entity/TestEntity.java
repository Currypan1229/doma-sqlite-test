package dev.currypan.test.doma.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "M_TEST")
public class TestEntity {
    @Column(name = "ID")
    @Id
    private String id;

    @Column(name = "VALUE")
    private String value;
}
