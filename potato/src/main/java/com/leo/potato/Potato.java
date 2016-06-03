package com.leo.potato;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Leo on 2016/5/23.
 */
public class Potato {
    public static void initInjection(final Activity act) {
        Field[] fields = act.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PotatoInjection.class)) {
                PotatoInjection potatoInjection = field.getAnnotation(PotatoInjection.class);
                int id = potatoInjection.id();
                String idStr = potatoInjection.idStr();
                final String clickStr = potatoInjection.click();
                final String longClickStr = potatoInjection.longClick();
//                String itemClickStr = potatoInjection.itemClick();
                field.setAccessible(true);
                Object view = null;
                try {
                    if (!TextUtils.isEmpty(idStr)) {
                        id = act.getResources().getIdentifier(idStr, "id", act.getPackageName());
                    }
                    //// TODO: 2016/5/23 idstr analysis
                    view = act.findViewById(id);
                    field.set(act, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (view instanceof View) {
                    View v = (View) view;
                    if (!TextUtils.isEmpty(clickStr)) {
                        ((View) view).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Method method = act.getClass().getMethod(clickStr);
                                    method.invoke(act);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    if (!TextUtils.isEmpty(longClickStr)) {
                        ((View) view).setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                try {
                                    Method method = act.getClass().getMethod(longClickStr);
                                    method.invoke(act);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return true;
                            }
                        });
                    }
                }
            }
        }
    }
}
