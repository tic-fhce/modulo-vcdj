package com.sgd.sgdfback.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class DocumentoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public DocumentoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Integer countByTramiteId(String tramiteId, String tabla) {
        String query = "SELECT COUNT(*) FROM " + tabla + " WHERE tramite_id = :tramiteId";
        Number result = (Number) entityManager.createNativeQuery(query)
                .setParameter("tramiteId", tramiteId)
                .getSingleResult();
        return result != null ? result.intValue() : 0;
    }

    @Transactional
    public void updateConvalidacion(String fileName, String newFileName, String nroTramite, String tabla) {
        String updateQuery = "UPDATE " + tabla + " SET d_" + fileName + " = :newFileName WHERE tramite_id = :nroTramite";
        entityManager.createNativeQuery(updateQuery)
                .setParameter("newFileName", newFileName)
                .setParameter("nroTramite", nroTramite)
                .executeUpdate();
    }

    @Transactional
    public void insertConvalidacion(Integer userId, String fileName, String newFileName, String tramiteId, String tabla) {
        String insertQuery = "INSERT INTO " + tabla + " (d_" + fileName + ", tramite_id, user_id) VALUES (:newFileName, :tramiteId, :userId)";
        entityManager.createNativeQuery(insertQuery)
                .setParameter("newFileName", newFileName)
                .setParameter("tramiteId", tramiteId)
                .setParameter("userId", userId)
                .executeUpdate();
    }

    public String obtenerNombreArchivo(String nroTramite, String columna, String tabla) {
        String query = "SELECT d_" + columna + " FROM " + tabla + " WHERE tramite_id = :nroTramite";
        return (String) entityManager.createNativeQuery(query)
                .setParameter("nroTramite", nroTramite)
                .getSingleResult();
    }

    @Transactional
    public void actualizarObservacionDoc(String columna, String observacion, String nroTramite, String tabla) {
        String updateQuery = "UPDATE " + tabla + " SET r_" + columna + " = :observacion WHERE tramite_id = :nroTramite";
        entityManager.createNativeQuery(updateQuery)
                .setParameter("observacion", observacion)
                .setParameter("nroTramite", nroTramite)
                .executeUpdate();
    }

    public String obtenerObservacionArchivo(String nroTramite, String columna, String tabla) {
        String query = "SELECT r_" + columna + " FROM " + tabla + " WHERE tramite_id = :nroTramite";
        return (String) entityManager.createNativeQuery(query)
                .setParameter("nroTramite", nroTramite)
                .getSingleResult();
    }
}
