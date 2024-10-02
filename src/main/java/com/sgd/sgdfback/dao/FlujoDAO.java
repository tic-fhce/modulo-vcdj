package com.sgd.sgdfback.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public class FlujoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public FlujoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Integer findRoleIdByUsername(String username) {
        String sql = "SELECT r.id FROM user u " +
                     "INNER JOIN user_role ur ON u.id = ur.user_id " +
                     "INNER JOIN role r ON ur.role_id = r.id " +
                     "WHERE u.username = :username";
        return (Integer) entityManager.createNativeQuery(sql)
                .setParameter("username", username)
                .getSingleResult();
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Transactional
    public List<Map<String, Object>> findFlujosByRoleIdAndProceso(Integer roleId, String proceso) {
        String sql = "SELECT * FROM flujo WHERE role_id = :roleId AND (proceso LIKE :proceso OR proceso LIKE :procesoWildcard)";
        return entityManager.createNativeQuery(sql)
                .setParameter("roleId", roleId)
                .setParameter("proceso", proceso)
                .setParameter("procesoWildcard", proceso + "-%")
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(org.hibernate.transform.AliasToEntityMapResultTransformer.INSTANCE)
                .getResultList();
    }
}
