package br.com.agillizapp.cadastros.domain.repositories.custom.impl;

import br.com.agillizapp.cadastros.domain.repositories.custom.BankCustomRepository;
import br.com.agillizapp.cadastros.domain.repositories.entities.BankEntity;
import br.com.agillizapp.cadastros.domain.services.filter.BankFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public class BankCustomRepositoryImpl implements BankCustomRepository {

    private static final String SEARCH_NAME = "name";
    private static final String SEARCH_CODE = "code";
    private static final String SEARCH_PERCENT = "%";

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<BankEntity> findByBankFilter(BankFilter filter, Pageable sortedByName) {
        var builder = manager.getCriteriaBuilder();
        var criteria = builder.createQuery(BankEntity.class);
        var root = criteria.from(BankEntity.class);

        var predicates = createRestrictions(filter, builder, root);
        criteria.where(predicates);
        criteria.orderBy((builder.desc(root.get("name"))));

        var query = manager.createQuery(criteria);
        addRestrictionsOfPagination(query, sortedByName );

        return new PageImpl<>(query.getResultList(), sortedByName, total(filter));
    }

    private Long total(BankFilter filter) {
        var builder = manager.getCriteriaBuilder();
        var criteria = builder.createQuery(Long.class);
        var root = criteria.from(BankEntity.class);
        var predicates = createRestrictions(filter, builder, root);
        criteria.where(predicates);
        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    static void addRestrictionsOfPagination(TypedQuery<BankEntity> query, Pageable pageable) {
        var actualPage = pageable.getPageNumber();
        var totalForPage = pageable.getPageSize();
        var firstPage = actualPage * totalForPage;

        query.setFirstResult(firstPage);
        query.setMaxResults(totalForPage);
    }

    private Predicate[] createRestrictions(BankFilter filter, CriteriaBuilder builder, Root<BankEntity> root) {
        var predicates = new ArrayList<>();

        if (StringUtils.isNotBlank(filter.getName())) {
            predicates.add(builder.like( builder.upper(root.get(SEARCH_NAME)),
                    StringUtils.upperCase(SEARCH_PERCENT.concat(filter.getName().trim()).concat(SEARCH_PERCENT))));
        }

        if (StringUtils.isNotBlank(filter.getCode())) {
            predicates.add(builder.equal(root.get(SEARCH_CODE), Integer.valueOf(filter.getCode())));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
