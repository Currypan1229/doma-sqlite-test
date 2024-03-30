package dev.currypan.test.doma.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "M_TEST")
public class TestEntity {
    @Column(name = "ID")
    private String id;

    @Column(name = "VALUE")
    private String value;
}
