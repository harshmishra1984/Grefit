package com.rimt.core;

import org.hibernate.EmptyInterceptor;
import org.hibernate.annotations.Filter;
import org.hibernate.type.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ReflectionUtils;

import com.rimt.common.exception.PermissionDeniedException;
import com.rimt.dataaccess.entities.UserAccount;

import java.io.Serializable;
import java.lang.reflect.Field;

import static java.lang.String.format;
import static com.rimt.core.AccountUtil.currentAccount;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static org.springframework.core.annotation.AnnotationUtils.getValue;
import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.makeAccessible;
import static org.springframework.util.ReflectionUtils.setField;

public class TenantInterceptor extends EmptyInterceptor {


	@Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (isMultiTenantable(entity) && currentAccount() != null) {
            UserAccount account = getAccount(state, propertyNames);
            if (!currentAccount().equals(account)) {
                String msg = format("Trying to load %s[id=%s] from account: %s, current account: %s",
                        entity.getClass().getSimpleName(), id, account, currentAccount());
               try {
				throw new PermissionDeniedException(msg);
			} catch (PermissionDeniedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
        }
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (isMultiTenantable(entity) && currentAccount() != null) {
            UserAccount account = getAccount(state, propertyNames);
            if (!currentAccount().equals(account)) {
                String msg = format("Trying to delete %s[id=%s] from account: %s, current account: %s",
                        entity.getClass().getSimpleName(), id, account, currentAccount());
                try {
					throw new PermissionDeniedException(msg);
				} catch (PermissionDeniedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (isMultiTenantable(entity) && currentAccount() != null) {
            UserAccount account = getAccount(currentState, propertyNames);
            if (!currentAccount().equals(account)) {
                String msg = format("Trying to update %s[id=%s] from account: %s, current account: %s",
                        entity.getClass().getSimpleName(), id, account, currentAccount());
                try {
					throw new PermissionDeniedException(msg);
				} catch (PermissionDeniedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (isMultiTenantable(entity) && currentAccount() != null) {
            UserAccount account = getAccount(state, propertyNames);
            if (account == null) {
                Field field = findField(entity.getClass(), "account");
                makeAccessible(field);
                setField(field, entity, currentAccount());

                for (int i = 0; i < propertyNames.length; i++) {
                    if (propertyNames[i].equals("account")) {
                        state[i] = currentAccount();
                        break;
                    }
                }
            } else if (!currentAccount().equals(account)) {
                String msg = format("Trying to save %s[id=%s] to account: %s, current account: %s",
                        entity.getClass().getSimpleName(), id, account, currentAccount());
                try {
					throw new PermissionDeniedException(msg);
				} catch (PermissionDeniedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }

    private UserAccount getAccount(Object[] state, String[] propertyNames) {
        for (int i = 0; i < propertyNames.length; i++) {
            if (propertyNames[i].equals("account")) {
                return (UserAccount) state[i];
            }
        }
        throw new RuntimeException("No such property: account");
    }

    private boolean isMultiTenantable(Object entity) {
        Filter annotation = findAnnotation(entity.getClass(), Filter.class);
        if (annotation == null) {
            return false;
        }
        return "account".equals(getValue(annotation, "name"));
    }
}
