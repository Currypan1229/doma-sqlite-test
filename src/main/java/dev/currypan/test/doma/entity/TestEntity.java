package dev.currypan.test.doma.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

@Data
@NoArgsConstructor
@Entity
@Table(name = "M_TEST")
public class TestEntity {
    @Column(name = "ID")
    @Id
    private long id;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "VERSION_NO")
    @Version
    private long versionNo;
}
