package com.philvigus.dbentityfactories.testfixtures.hibernate.factories;

import com.philvigus.dbentityfactories.annotations.EntityFactory;
import com.philvigus.dbentityfactories.attributes.DefaultAttribute;
import com.philvigus.dbentityfactories.factories.BaseEntityFactory;
import com.philvigus.dbentityfactories.factories.HibernateEntityFactory;
import com.philvigus.dbentityfactories.testfixtures.entities.BasicEntity;
import net.datafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

/**
 * The Basic entity factory used by tests for this library.
 */
@EntityFactory
public class BrokenBasicEntityHibernateFactory extends HibernateEntityFactory<BasicEntity> {
    public static final String INCORRECT_ATTRIBUTE_NAME = "iDoNotExist";
    public static final String STRING_ATTRIBUTE_NAME = "myStringAttribute";

    private static final Faker faker = new Faker();

    /**
     * Instantiates a new Basic entity factory.
     *
     * @param repository the repository used to save instances of the entity
     */
    public BrokenBasicEntityHibernateFactory(final JpaRepository<BasicEntity, Long> repository) {
        super(BasicEntity.class, repository);
    }

    @Override
    protected Map<String, DefaultAttribute<?>> getDefaultAttributes(final BaseEntityFactory<?>... dependentFactories) {
        return toAttributeMap(
                new DefaultAttribute<>(BrokenBasicEntityHibernateFactory.INCORRECT_ATTRIBUTE_NAME, () -> BrokenBasicEntityHibernateFactory.faker.number().numberBetween(1L, 5L)),
                new DefaultAttribute<>(BrokenBasicEntityHibernateFactory.STRING_ATTRIBUTE_NAME, () -> BrokenBasicEntityHibernateFactory.faker.lorem().sentence())
        );
    }
}
