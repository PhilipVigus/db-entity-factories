package com.philvigus.dbentityfactories.testfixtures.factories;

import com.philvigus.dbentityfactories.AbstractBaseEntityFactory;
import com.philvigus.dbentityfactories.annotations.EntityFactory;
import com.philvigus.dbentityfactories.attributes.DefaultAttribute;
import com.philvigus.dbentityfactories.testfixtures.entities.BasicEntity;
import net.datafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

@EntityFactory
public class BasicEntityFactory extends AbstractBaseEntityFactory<BasicEntity> {
    private static final Faker faker = new Faker();

    public BasicEntityFactory(final JpaRepository<BasicEntity, Long> repository) {
        super(BasicEntity.class, repository, Map.of(
                "myLongAttribute", new DefaultAttribute<>("myLongAttribute", () -> BasicEntityFactory.faker.number().numberBetween(1L, 5L)),
                "myStringAttribute", new DefaultAttribute<>("myStringAttribute", () -> BasicEntityFactory.faker.lorem().sentence())
        ));
    }
}
