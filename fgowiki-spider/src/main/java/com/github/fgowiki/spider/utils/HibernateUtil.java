package com.github.fgowiki.spider.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * HibernateUtil工具类
 *
 * @author jiang
 * @create 2017-11-27 21:12
 **/
public final class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> session = new ThreadLocal<Session>();

    static {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }

    public static Session getThreadLocalSession() {
        Session s = session.get();
        if (s == null) {
            s = getSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() {
        Session s = session.get();
        if (s != null) {
            s.close();
            session.set(null);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void add(Object entity) {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.save(entity);
            tx.commit();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public static void saveOrUpdate(Object entity) {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.saveOrUpdate(entity);
            tx.commit();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public static void delete(Object entity) {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.delete(entity);
            tx.commit();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public static Object get(Class<?> clazz, Serializable id) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            return s.get(clazz, id);
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
/*
    public static List queryForlist(String sql, Object... params) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            NativeQuery nativeQuery = s.createNativeQuery(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    nativeQuery.setParameter(i + 1, params[i]);
                }
            }
            return nativeQuery.list();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }*/

    public static List queryForlist(String sql, Object... params) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            Query query = s.createQuery(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i + 1, params[i]);
                }
            }
            return query.list();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}